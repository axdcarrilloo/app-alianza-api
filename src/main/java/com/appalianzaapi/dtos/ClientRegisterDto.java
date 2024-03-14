package com.appalianzaapi.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientRegisterDto {
    private String businessId;
    private String email;
    private String phone;
    private String startDate;
    private String endDate;
}
