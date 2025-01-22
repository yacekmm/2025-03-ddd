package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.period.Period;

import java.util.UUID;

public class TrainingException extends RuntimeException {
    private final UUID trainingDefinitionId;
    private final Period period;

    private TrainingException(String message, UUID trainingDefinitionId, Period period) {
        super(message);
        this.trainingDefinitionId = trainingDefinitionId;
        this.period = period;
    }

    static RuntimeException tooLong(UUID trainingDefinitionId, Period period) {
        return new TrainingException("training cannot take more than 5 days", trainingDefinitionId, period);
    }

    static RuntimeException alreadyScheduled(UUID trainingDefinitionId, Period period) {
        return new TrainingException("training already scheduled", trainingDefinitionId, period);
    }
}
