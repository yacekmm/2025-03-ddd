package com.smalaca.trainingmanagement.domain.trainingidea;

import java.util.UUID;

public interface TrainingIdeaRepository {
    void save(TrainingIdea trainingIdea);

    TrainingIdea findById(UUID trainingIdeaId);
}
