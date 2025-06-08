package com.pe.edu.upc.center.payment.application.internal.outboundservices.acl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExternalCardService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    public boolean isCardExists(int cardId) throws IOException, InterruptedException {
        String cardServiceUrl = "http://card-service:8090/api/v1/cards/";
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(cardServiceUrl + cardId))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return true;
            } else if (response.statusCode() == 404) {
                return false;
            } else {
                throw new RuntimeException("Unexpected response from card service: " + response.statusCode());
            }
        }
}
