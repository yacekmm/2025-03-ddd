package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.period.Period;

public class TrainingException extends RuntimeException {
    private final Period period;

    private TrainingException(String message, Period period) {
        super(message);
        this.period = period;
    }

    static RuntimeException tooLong(Period period) {
        return new TrainingException("training cannot take more than 5 days", period);
    }
}
