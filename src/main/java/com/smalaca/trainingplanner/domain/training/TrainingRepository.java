package com.smalaca.trainingplanner.domain.training;

import java.util.UUID;

public interface TrainingRepository {
    void save(Training training);

    Training findById(UUID trainingId);
}
