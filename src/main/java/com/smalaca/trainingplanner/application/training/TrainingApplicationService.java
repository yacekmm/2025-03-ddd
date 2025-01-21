package com.smalaca.trainingplanner.application.training;

import com.smalaca.trainingplanner.domain.training.Training;
import com.smalaca.trainingplanner.domain.training.TrainingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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

    @Transactional
    public void move(UUID trainingId) {
        Training training = repository.findById(trainingId);

        training.move();

        repository.save(training);
    }

    @Transactional
    public void cancel(UUID trainingId) {
        Training training = repository.findById(trainingId);

        training.cancel();

        repository.save(training);
    }
}
