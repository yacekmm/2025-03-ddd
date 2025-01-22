package com.smalaca.trainingmanagement.domain.trainingdraft;

import java.util.UUID;

public class InvalidTrainingGuardingException extends RuntimeException {
    private final UUID trainerId;

    InvalidTrainingGuardingException(UUID trainerId) {
        this.trainerId = trainerId;
    }
}
