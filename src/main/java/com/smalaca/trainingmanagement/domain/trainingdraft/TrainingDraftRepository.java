package com.smalaca.trainingmanagement.domain.trainingdraft;

import java.util.UUID;

public interface TrainingDraftRepository {
    void save(TrainingDraft draft);

    TrainingDraft findById(UUID uuid);
}
