package com.pe.edu.upc.center.payment.application.internal.queryservices;

import com.pe.edu.upc.center.payment.domain.model.aggregates.Payment;
import com.pe.edu.upc.center.payment.domain.model.queries.GetPaymentByUserQuery;
import com.pe.edu.upc.center.payment.domain.services.PaymentQueryService;
import com.pe.edu.upc.center.payment.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> handle(GetPaymentByUserQuery query) {
        return paymentRepository.findAllByUserId(query.userId())
                .stream().toList();
    }
}