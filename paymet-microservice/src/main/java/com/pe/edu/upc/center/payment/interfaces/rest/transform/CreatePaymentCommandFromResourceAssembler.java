package com.pe.edu.upc.center.payment.interfaces.rest.transform;


import com.pe.edu.upc.center.payment.domain.model.commands.CreatePaymentCommand;
import com.pe.edu.upc.center.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(resource.userId(), resource.reservationId(), resource.cardId());
    }
}

