package com.pe.edu.upc.center.payment.interfaces.rest.resources;

public record CreatePaymentResource(int userId,
                                    int reservationId,
                                    int cardId) {
}

