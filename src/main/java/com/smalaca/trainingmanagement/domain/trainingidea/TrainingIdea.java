package com.smalaca.trainingmanagement.domain.trainingidea;

import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;

import java.util.UUID;

import static com.smalaca.trainingmanagement.domain.trainingidea.IdeaStatus.OPEN;

// aggregate root
public class TrainingIdea {
    private String name;
    private UUID trainerId;
    private IdeaStatus status;

    TrainingIdea(UUID trainerId, String name) {
        this.trainerId = trainerId;
        this.name = name;
        this.status = OPEN;
    }

    // factory
    public TrainingDraft accept() {
        return new TrainingDraft();
    }

    boolean isNotValidated() {
        return OPEN.equals(status);
    }
}
