package com.appalianzaapi.controllers;

import com.appalianzaapi.dtos.ClientRegisterDto;
import com.appalianzaapi.dtos.MainResponseDto;
import com.appalianzaapi.services.ClientService;
import com.appalianzaapi.utils.Constants;
import com.appalianzaapi.utils.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Route.URL_BASE+Route.URL_CLIENT)
@CrossOrigin(origins = Route.URL_REQUEST)
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientSvc;

    @PostMapping(value = Route.ADVANCED_SEARCH)
    public ResponseEntity<MainResponseDto> getAdvancedSearch(@RequestBody ClientRegisterDto clientDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .mesagge(Constants.SUCCESSFUL_QUERY)
                .response(clientSvc.getAdvancedSearch(clientDto))
                .build(), HttpStatus.OK)
        ;
    }

    @GetMapping(value = Route.GETBY_SHAREDKEY)
    public ResponseEntity<MainResponseDto> getBySharedKey(@PathVariable String sharedKey){
        return new ResponseEntity<>(MainResponseDto.builder()
                .mesagge(Constants.SUCCESSFUL_QUERY)
                .response(clientSvc.getBySharedKey(sharedKey))
                .build(), HttpStatus.OK)
        ;
    }
    @GetMapping(value = Route.GETALL)
    public ResponseEntity<MainResponseDto> getAll(){
        return new ResponseEntity<>(MainResponseDto.builder()
                .mesagge(Constants.SUCCESSFUL_QUERY)
                .response(clientSvc.getAll())
                .build(), HttpStatus.OK)
        ;
    }
    @PostMapping(value = Route.REGISTER)
    public ResponseEntity<MainResponseDto> register(@RequestBody ClientRegisterDto clientDto) {
        return new ResponseEntity<>(MainResponseDto.builder()
                .mesagge(Constants.SUCCESSFUL_REGISTRATION)
                .response(clientSvc.register(clientDto))
                .build(), HttpStatus.CREATED)
        ;
    }
}
