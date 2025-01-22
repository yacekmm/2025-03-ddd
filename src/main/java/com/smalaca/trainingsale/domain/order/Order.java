package com.smalaca.trainingsale.domain.order;

import com.smalaca.trainingsale.domain.price.Price;

import java.util.UUID;

// aggregate root
public class Order {
    private final UUID offerId;
    private final UUID trainingId;
    private final Price price;

    public Order(UUID offerId, UUID trainingId, Price price) {
        this.offerId = offerId;
        this.trainingId = trainingId;
        this.price = price;
    }
}
