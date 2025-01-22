package com.smalaca.trainingsale.domain.trainingplanner;

import com.smalaca.trainingsale.domain.price.Price;

import java.util.UUID;

public interface TrainingPlanner {
    boolean book(UUID trainingId, UUID participantId);

    Price priceOf(UUID trainingId);
}
