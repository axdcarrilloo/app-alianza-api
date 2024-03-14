package com.appalianzaapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "clients")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shared_key", nullable = false, unique = true)
    private String sharedKey;

    @Column(name = "business_id", nullable = false, unique = true)
    private String businessId;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
