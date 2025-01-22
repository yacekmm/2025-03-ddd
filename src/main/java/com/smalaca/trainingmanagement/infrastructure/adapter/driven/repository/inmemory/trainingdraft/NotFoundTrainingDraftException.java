package com.smalaca.trainingmanagement.infrastructure.adapter.driven.repository.inmemory.trainingdraft;

import java.util.UUID;

public class NotFoundTrainingDraftException extends RuntimeException {
    NotFoundTrainingDraftException(UUID trainingDraftId) {
    }
}
