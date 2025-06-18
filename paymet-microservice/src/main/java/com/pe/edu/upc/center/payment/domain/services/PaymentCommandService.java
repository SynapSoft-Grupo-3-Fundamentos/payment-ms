package com.pe.edu.upc.center.payment.domain.services;


import com.pe.edu.upc.center.payment.domain.model.commands.CreatePaymentCommand;

public interface PaymentCommandService {
    void handle(CreatePaymentCommand command);
}

