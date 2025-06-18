package com.pe.edu.upc.center.payment.application.internal.queryservices;

import com.pe.edu.upc.center.payment.application.internal.outboundservices.acl.ExternalCardService;
import com.pe.edu.upc.center.payment.domain.model.aggregates.Payment;
import com.pe.edu.upc.center.payment.domain.model.commands.CreatePaymentCommand;
import com.pe.edu.upc.center.payment.domain.services.PaymentCommandService;
import com.pe.edu.upc.center.payment.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;
    private final ExternalCardService externalCardService;


    public PaymentCommandServiceImpl(PaymentRepository paymentRepository,  ExternalCardService externalCardService) {
        this.paymentRepository = paymentRepository;
        this.externalCardService = externalCardService;
    }

    @Override
    public void handle(CreatePaymentCommand command) {


        try{
            boolean isCardExists = externalCardService.isCardExists(command.cardId());
            if (!isCardExists){
                throw new RuntimeException("This card given does not exist");
            }
            Payment payment = new Payment(command);
            paymentRepository.save(payment);

        } catch (Exception ex) {
            throw new RuntimeException("Error checking card existence", ex);
        }
    }
}
