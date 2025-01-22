package com.smalaca.trainingmanagement.infrastructure.adapter.driven.repository.inmemory.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraftRepository;

import java.util.Optional;
import java.util.UUID;

public class InMemoryTrainingDraftRepository implements TrainingDraftRepository {
    @Override
    public void save(TrainingDraft draft) {

    }

    @Override
    public TrainingDraft findById(UUID trainingDraftId) {
        Optional<TrainingDraft> found = findTrainingDraftById(trainingDraftId);

        return found.orElseThrow(() -> new NotFoundTrainingDraftException(trainingDraftId));
    }

    private Optional<TrainingDraft> findTrainingDraftById(UUID trainingDraftId) {
        return null;
    }
}
