package com.smalaca.trainingplanner.application.training;

import com.smalaca.trainingplanner.domain.training.Training;
import com.smalaca.trainingplanner.domain.training.TrainingRepository;
import org.springframework.transaction.annotation.Transactional;

public class TrainingApplicationService {
    private final TrainingRepository repository;

    TrainingApplicationService(TrainingRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void book() {
        Training training = new Training();

        repository.save(training);
    }
}
