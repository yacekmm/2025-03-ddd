package com.smalaca.trainingmanagement.domain.trainingidea;

import java.util.UUID;

public class AlreadyExistingTrainingIdeaException extends RuntimeException {
    private final UUID trainerId;
    private final String name;

    AlreadyExistingTrainingIdeaException(UUID trainerId, String name) {
        this.trainerId = trainerId;
        this.name = name;
    }
}
