package com.smalaca.trainingsale.domain.offer;

import java.util.UUID;

public class NotAvailabeTrainingException extends RuntimeException {
    private final UUID trainingId;

    NotAvailabeTrainingException(UUID trainingId) {
        this.trainingId = trainingId;
    }
}
