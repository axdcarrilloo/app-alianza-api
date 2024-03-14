package com.appalianzaapi.services;

import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.ClientViewDto;

import java.util.List;

public interface ClientService {
    ClientViewDto getAdvancedSearch(ClientRegisterDto clientDto);
    List<ClientViewDto> getAll();
    ClientViewDto getBySharedKey(String sharedKey);
    Long register(ClientRegisterDto clientDto);
}
