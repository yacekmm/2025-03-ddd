package com.smalaca.trainingplanner.domain.training;

public class InvalidTrainingTypeException extends RuntimeException {
    private final String invalidTrainingType;

    InvalidTrainingTypeException(String invalidTrainingType) {
        this.invalidTrainingType = invalidTrainingType;
    }
}
