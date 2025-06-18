package com.pe.edu.upc.center.payment.interfaces.rest.transform;


import com.pe.edu.upc.center.payment.domain.model.aggregates.Payment;
import com.pe.edu.upc.center.payment.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment entity) {
        return new PaymentResource(entity.getId(), entity.getUserId(), entity.getReservationId(), entity.getCardId(), entity.getCreatedAt());
    }
}
