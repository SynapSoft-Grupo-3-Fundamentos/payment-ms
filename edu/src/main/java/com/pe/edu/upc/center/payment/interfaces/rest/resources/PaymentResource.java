package com.pe.edu.upc.center.payment.interfaces.rest.resources;


import java.util.Date;

public record PaymentResource(
        int id,
        int userId,
       int reservationId,
        int cardId,
        Date createdAt) {
}
