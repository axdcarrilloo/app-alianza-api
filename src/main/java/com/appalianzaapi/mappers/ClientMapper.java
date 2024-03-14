package com.appalianzaapi.mappers;

import com.appalianzaapi.domain.entities.ClientEntity;
import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.ClientViewDto;
import com.appalianzaapi.utils.BuildSharedKey;
import com.appalianzaapi.utils.FormatDate;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    public static List<ClientViewDto> convertToListDto(List<ClientEntity> clientsEntity) {
        List<ClientViewDto> clientsDto = new ArrayList<>();
        clientsEntity.forEach(clientEntity -> clientsDto.add(ClientViewDto.builder()
                        .id(clientEntity.getId())
                        .sharedKey(clientEntity.getSharedKey())
                        .businessId(clientEntity.getBusinessId())
                        .email(clientEntity.getEmail())
                        .phone(clientEntity.getPhone())
                        .startDate(clientEntity.getStartDate())
                        .endDate(clientEntity.getEndDate())
                .build()));
        return clientsDto;
    }
    public static ClientViewDto converToDto(ClientEntity clientEntity) {
        return ClientViewDto.builder()
                .id(clientEntity.getId())
                .sharedKey(clientEntity.getSharedKey())
                .businessId(clientEntity.getBusinessId())
                .email(clientEntity.getEmail())
                .phone(clientEntity.getPhone())
                .startDate(clientEntity.getStartDate())
                .endDate(clientEntity.getEndDate())
                .build()
        ;
    }
    public static ClientEntity converToEntity(ClientRegisterDto clientDto) {
        return ClientEntity.builder()
                .id(0L)
                .sharedKey(BuildSharedKey.buildSharedKey(clientDto.getBusinessId()))
                .businessId(clientDto.getBusinessId())
                .email(clientDto.getEmail())
                .phone(clientDto.getPhone())
                .startDate(FormatDate.formatDate(clientDto.getStartDate()))
                .endDate(FormatDate.formatDate(clientDto.getEndDate()))
                .build()
        ;
    }
}
