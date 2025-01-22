package com.smalaca.trainingmanagement.domain.trainingidea;

import java.util.List;
import java.util.UUID;

public interface TrainingIdeaRepository {
    void save(TrainingIdea trainingIdea);

    TrainingIdea findById(UUID trainingIdeaId);

    List<TrainingIdea> findAllBy(UUID trainerId, String name);
}
