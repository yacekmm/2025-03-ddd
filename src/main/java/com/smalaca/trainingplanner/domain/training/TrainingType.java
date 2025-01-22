package com.smalaca.trainingplanner.domain.training;

// value object
public enum TrainingType {
    REMOTE, ONSITE;

    public static TrainingType create(String value) {
        try {
            return TrainingType.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidTrainingTypeException(value);
        }
    }
}
