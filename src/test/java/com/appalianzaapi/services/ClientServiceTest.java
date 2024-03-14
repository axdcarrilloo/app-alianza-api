package com.appalianzaapi.services;

import com.appalianzaapi.domain.entities.ClientEntity;
import com.appalianzaapi.domain.repositories.ClientRepository;
import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.ClientViewDto;
import com.appalianzaapi.services.impl.ClientServiceImpl;
import com.appalianzaapi.utils.BuildSharedKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientSvc;

    @Test
    void getAllTest() {
        List<ClientEntity> clients = new ArrayList<>();
        ClientEntity clientEntity = ClientEntity.builder().id(12L).sharedKey(BuildSharedKey.buildSharedKey("Ana Claver Chica"))
                .businessId("Ana Claver Chica").email("ancl@aqui.com").phone("344658521").startDate(LocalDate.of(2023, 3, 10))
                .endDate(LocalDate.of(2024, 3, 10)).build()
        ;
        ClientEntity clientEntity2 = ClientEntity.builder().id(12L).sharedKey(BuildSharedKey.buildSharedKey("Maria Navarro"))
                .businessId("Maria Navarro").email("mana@aqui.com").phone("36698547").startDate(LocalDate.of(2023, 6, 2))
                .endDate(LocalDate.of(2024, 1, 14)).build()
        ;

        clients.add(clientEntity);
        clients.add(clientEntity2);

        when(clientRepository.findAll()).thenReturn(clients);

        List<ClientViewDto> clientsViewDto = clientSvc.getAll();

        assertFalse(clientsViewDto.isEmpty());
        assertEquals(2, clientsViewDto.size());
    }

    @Test
    void getBySharedKeyTest() {
        ClientEntity clientEntity = ClientEntity.builder()
                .id(12L)
                .sharedKey(BuildSharedKey.buildSharedKey("Ana Claver Chica"))
                .businessId("Ana Claver Chica")
                .email("ancl@aqui.com")
                .phone("344658521")
                .startDate(LocalDate.of(2023, 3, 10))
                .endDate(LocalDate.of(2024, 3, 10))
                .build()
        ;
        Optional<ClientEntity> optional = Optional.of(clientEntity);

        when(clientRepository.findBySharedKey("aclaver")).thenReturn(optional);

        ClientViewDto clientViewDto = clientSvc.getBySharedKey("aclaver");

        assertNotNull(clientViewDto);
        assertEquals("aclaver", clientViewDto.getSharedKey());
        assertEquals(12L, clientViewDto.getId());
    }

    @Test
    void registerTest() {
        ClientEntity clientEntity = ClientEntity.builder()
                .id(12L)
                .sharedKey(BuildSharedKey.buildSharedKey("Ana Claver Chica"))
                .businessId("Ana Claver Chica")
                .email("ancl@aqui.com")
                .phone("344658521")
                .startDate(LocalDate.of(2023, 3, 10))
                .endDate(LocalDate.of(2024, 3, 10))
                .build()
        ;
        ClientRegisterDto clientDto = ClientRegisterDto.builder()
                .businessId("Ana Claver Chica")
                .email("ancl@aqui.com")
                .phone("34468521")
                .startDate("2023-03-10")
                .endDate("2024-03-10")
                .build()
        ;

        when(clientRepository.save(any())).thenReturn(clientEntity);

        Long idResponse = clientSvc.register(clientDto);

        assertNotNull(idResponse);
        assertEquals(12L, idResponse);
    }

}
