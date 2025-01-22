package com.smalaca.trainingsale.infrastructure.adapter.driven.trainingplanner.rest;

import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.UUID;

public class RestTrainingPlannerClient implements TrainingPlanner {
    private final RestClient restClient;

    public RestTrainingPlannerClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public boolean book(UUID trainingId, UUID participantId) {
        try {
            BookingResponse dto = restClient
                    .post()
                    .uri("fake/url/to/book/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new BookingRequest(trainingId, participantId))
                    .retrieve()
                    .body(BookingResponse.class);
            return dto.status();
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public Price priceOf(UUID trainingId) {
        return null;
    }
}
