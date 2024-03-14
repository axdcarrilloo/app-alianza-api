package com.appalianzaapi.services.impl;

import com.appalianzaapi.domain.entities.ClientEntity;
import com.appalianzaapi.domain.repositories.ClientRepository;
import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.ClientViewDto;
import com.appalianzaapi.mappers.ClientMapper;
import com.appalianzaapi.services.ClientService;
import com.appalianzaapi.utils.FormatDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private ClientEntity getBySharedKeyReturnEntity(String sharedKey) {
        log.info("ClientServiceImpl.class - getBySharedKeyReturnEntity() -> Querying user by shared key..!");
        return clientRepository.findBySharedKey(sharedKey).orElse(null);
    }

    @Override
    public ClientViewDto getAdvancedSearch(ClientRegisterDto clientDto) {
        ClientEntity clientEntity = clientRepository.findByBusinessIdAndEmailAndPhoneAndStartDateAndEndDate(clientDto.getBusinessId(),
                clientDto.getEmail(), clientDto.getPhone(), FormatDate.formatDate(clientDto.getStartDate())
                , FormatDate.formatDate(clientDto.getEndDate())).orElse(null);
        if(clientEntity != null) {
            return ClientMapper.converToDto(clientEntity);
        } else return null;
    }
    @Override
    public List<ClientViewDto> getAll() {
        log.info("ClientServiceImpl.class - getAll() -> Consulting all users..!");
        return ClientMapper.convertToListDto(clientRepository.findAll());
    }
    @Override
    public ClientViewDto getBySharedKey(String sharedKey) {
        log.info("ClientServiceImpl.class - getBySharedKey() -> Querying user by shared key..!");
        ClientEntity clientEntity = getBySharedKeyReturnEntity(sharedKey);
        if(clientEntity != null) {
            return ClientMapper.converToDto(clientEntity);
        } else return null;
    }
    @Override
    public Long register(ClientRegisterDto clientDto) {
        log.info("ClientServiceImpl.class - register() -> Registering user..!");
        return clientRepository.save(ClientMapper.converToEntity(clientDto)).getId();
    }
}
