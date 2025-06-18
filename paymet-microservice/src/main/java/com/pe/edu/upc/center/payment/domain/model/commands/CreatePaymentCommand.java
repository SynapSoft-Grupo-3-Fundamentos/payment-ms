package com.pe.edu.upc.center.payment.domain.model.commands;

public record CreatePaymentCommand(int userId, int reservationId, int cardId) {
}

