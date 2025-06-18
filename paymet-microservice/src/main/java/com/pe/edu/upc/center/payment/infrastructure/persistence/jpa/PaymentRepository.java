package com.pe.edu.upc.center.payment.infrastructure.persistence.jpa;

import com.pe.edu.upc.center.payment.domain.model.aggregates.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findAllByUserId(int userId);
}
