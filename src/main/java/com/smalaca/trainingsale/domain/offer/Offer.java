package com.smalaca.trainingsale.domain.offer;

import com.smalaca.trainingsale.domain.order.Order;
import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;

import java.util.UUID;

// aggregate root
public class Offer {
    private UUID offerId;
    private UUID trainingId;
    private Price price;

    Offer(UUID trainingId, Price price) {
        this.trainingId = trainingId;
        this.price = price;
    }

    public Order accept(TrainingPlanner trainingPlanner) {
        if (!trainingPlanner.book(trainingId)) {
            throw new NotAvailabeTrainingException(trainingId);
        }

        return new Order(offerId, trainingId, price);
    }
}
