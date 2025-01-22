package com.smalaca.trainingsale.domain.offer;

import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;

import java.util.UUID;

public class OfferFactory {
    private final TrainingPlanner trainingPlanner;

    OfferFactory(TrainingPlanner trainingPlanner) {
        this.trainingPlanner = trainingPlanner;
    }

    public Offer create(UUID trainingId, UUID participantId) {
        Price price = trainingPlanner.priceOf(trainingId);

        return new Offer(trainingId, participantId, price);
    }
}
