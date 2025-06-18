package com.pe.edu.upc.center.payment.domain.model.aggregates;

import com.pe.edu.upc.center.payment.domain.model.commands.CreatePaymentCommand;
import com.pe.edu.upc.center.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table(name = "payment")
public class Payment extends AuditableAbstractAggregateRoot<Payment> {


    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int reservationId;

    @Column(nullable = false)
    private int cardId;


    public Payment() {
    }

    public Payment(CreatePaymentCommand command) {
        this.userId = command.userId();
        this.reservationId = command.reservationId();
        this.cardId = command.cardId();
    }
}
