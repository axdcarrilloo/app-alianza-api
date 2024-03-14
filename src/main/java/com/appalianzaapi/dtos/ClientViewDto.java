package com.appalianzaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ClientViewDto {
    private Long id;
    private String sharedKey;
    private String businessId;
    private String email;
    private String phone;
    private LocalDate startDate;
    private LocalDate endDate;
}
