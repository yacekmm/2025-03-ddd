package com.smalaca.trainingmanagement.domain.trainingidea;

import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;

import java.util.UUID;

// aggregate root
public class TrainingIdea {
    private String name;
    private UUID trainerId;

    // factory
    public TrainingDraft accept() {
        return new TrainingDraft();
    }
}
