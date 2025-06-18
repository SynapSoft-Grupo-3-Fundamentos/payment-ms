package com.pe.edu.upc.center.payment.domain.services;



import com.pe.edu.upc.center.payment.domain.model.aggregates.Payment;
import com.pe.edu.upc.center.payment.domain.model.queries.GetPaymentByUserQuery;

import java.util.List;

public interface PaymentQueryService {
    List<Payment> handle(GetPaymentByUserQuery query);
}
