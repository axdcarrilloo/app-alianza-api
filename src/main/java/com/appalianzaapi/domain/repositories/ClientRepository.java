package com.appalianzaapi.domain.repositories;

import com.appalianzaapi.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByBusinessIdAndEmailAndPhoneAndStartDateAndEndDate(String businessId, String email, String phone,
                                                                                  LocalDate startDate, LocalDate endDate);
    Optional<ClientEntity> findBySharedKey(String sharedKey);
}
