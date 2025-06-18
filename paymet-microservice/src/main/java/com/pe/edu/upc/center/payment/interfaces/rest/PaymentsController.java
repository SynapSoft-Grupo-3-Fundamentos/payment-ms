package com.pe.edu.upc.center.payment.interfaces.rest;

import com.pe.edu.upc.center.payment.domain.model.queries.GetPaymentByUserQuery;
import com.pe.edu.upc.center.payment.domain.services.PaymentCommandService;
import com.pe.edu.upc.center.payment.domain.services.PaymentQueryService;
import com.pe.edu.upc.center.payment.interfaces.rest.resources.CreatePaymentResource;
import com.pe.edu.upc.center.payment.interfaces.rest.resources.PaymentResource;
import com.pe.edu.upc.center.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.pe.edu.upc.center.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Payments", description = "Payment Management Endpoint")
public class PaymentsController {

    private final PaymentQueryService paymentQueryService;
    private final PaymentCommandService paymentCommandService;

    public PaymentsController(PaymentQueryService paymentQueryService, PaymentCommandService paymentCommandService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentCommandService = paymentCommandService;
    }

    @GetMapping("/{profileId}")
    ResponseEntity<List<PaymentResource>> handle(@PathVariable int profileId) {
        GetPaymentByUserQuery getPaymentByUserQuery = new GetPaymentByUserQuery(profileId);
        var payments = this.paymentQueryService.handle(getPaymentByUserQuery);

        return new ResponseEntity<>(
                payments
                        .stream()
                        .map(PaymentResourceFromEntityAssembler::toResourceFromEntity)
                        .toList()
                , HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Boolean> createPayment(@RequestBody CreatePaymentResource resource) {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        this.paymentCommandService.handle(createPaymentCommand);
        return ResponseEntity.ok(true);

    }


}