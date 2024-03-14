package com.appalianzaapi.controllers;

import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.ClientViewDto;
import com.appalianzaapi.services.ClientService;
import com.appalianzaapi.utils.Constants;
import com.appalianzaapi.utils.Route;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientSvc;

    private String convertToJSONFromClientRegisterDto(ClientRegisterDto clientDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(clientDto);
    }

    @Test
    void getBySharedKeyTest() throws Exception {
        ClientViewDto clientDto = ClientViewDto.builder()
                .id(13L)
                .sharedKey("ycutiz")
                .businessId("Yurani Isabel Cutiz Martinez")
                .email("yuiscuma@aqui.com")
                .phone("3554178")
                .startDate(LocalDate.of(2023, 3, 10))
                .endDate(LocalDate.of(2024, 3, 10))
                .build()
        ;

        when(clientSvc.getBySharedKey("ycutiz")).thenReturn(clientDto);

        mockMvc.perform(get(Route.URL_BASE+Route.URL_CLIENT+"/GetBySharedKey/ycutiz")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> jsonPath("$.message", Constants.SUCCESSFUL_QUERY))
        ;
    }
    @Test
    void getAllTest() throws Exception {
        mockMvc.perform(get(Route.URL_BASE+Route.URL_CLIENT+Route.GETALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> jsonPath("$.message", Constants.SUCCESSFUL_QUERY))
        ;
    }
    @Test
    void registerTest() throws Exception {
        ClientRegisterDto clientDto = ClientRegisterDto.builder()
                .businessId("Ana Claver Chica")
                .email("ancl@aqui.com")
                .phone("34468521")
                .startDate("2023-03-10")
                .endDate("2024-03-10")
                .build()
        ;

        when(clientSvc.register(any())).thenReturn(12L);

        mockMvc.perform(post(Route.URL_BASE+Route.URL_CLIENT+Route.REGISTER)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertToJSONFromClientRegisterDto(clientDto)))
                .andExpect(status().isCreated())
                .andExpect(result -> jsonPath("$.message", Constants.SUCCESSFUL_REGISTRATION))
                .andExpect(result -> jsonPath("$.response", 12L))
        ;
    }

}
