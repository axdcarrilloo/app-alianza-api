package com.appalianzaapi.domain.entities;


import com.appalianzaapi.utils.BuildSharedKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ClientEntityTest {

    @Test
    void validateConstructor() {
        ClientEntity clientEntity = ClientEntity.builder()
                .id(12L)
                .sharedKey(BuildSharedKey.buildSharedKey("Maria Antonieta Virgo Nieves"))
                .businessId("Maria Antonieta Virgo Nieves")
                .email("maanvirni@aqui.es")
                .phone("344658521")
                .startDate(LocalDate.of(2023, 3, 10))
                .endDate(LocalDate.of(2024, 3, 10))
                .build()
        ;

        assertNotNull(clientEntity);
        assertEquals("344658521", clientEntity.getPhone());
        assertEquals("maanvirni@aqui.es", clientEntity.getEmail());
    }

}
