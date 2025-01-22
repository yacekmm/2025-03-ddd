package com.smalaca.trainingmanagement.domain.trainingdraft;

public class MissingCategoriesException extends RuntimeException {
    private final TrainingDraftNumber number;

    MissingCategoriesException(TrainingDraftNumber number) {
        this.number = number;
    }
}
