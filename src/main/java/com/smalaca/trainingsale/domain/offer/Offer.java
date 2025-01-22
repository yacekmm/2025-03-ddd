package com.smalaca.trainingsale.domain.offer;

import com.smalaca.trainingsale.domain.order.Order;
import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;

import java.util.UUID;

// aggregate root
public class Offer {
    private UUID offerId;
    private UUID trainingId;
    private final UUID participantId;
    private Price price;

    Offer(UUID trainingId, UUID participantId, Price price) {
        this.trainingId = trainingId;
        this.participantId = participantId;
        this.price = price;
    }

    public Order accept(TrainingPlanner trainingPlanner) {
        if (!trainingPlanner.book(trainingId, participantId)) {
            throw new NotAvailabeTrainingException(trainingId);
        }

        return new Order(offerId, trainingId, participantId, price);
    }
}
