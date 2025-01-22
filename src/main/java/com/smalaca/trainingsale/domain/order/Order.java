package com.smalaca.trainingsale.domain.order;

import com.smalaca.trainingsale.domain.price.Price;

import java.util.UUID;

// aggregate root
public class Order {
    private final UUID offerId;
    private final UUID trainingId;
    private final UUID participantId;
    private final Price price;

    public Order(UUID offerId, UUID trainingId, UUID participantId, Price price) {
        this.offerId = offerId;
        this.trainingId = trainingId;
        this.participantId = participantId;
        this.price = price;
    }
}
