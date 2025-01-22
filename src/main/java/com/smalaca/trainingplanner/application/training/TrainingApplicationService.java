package com.smalaca.trainingplanner.application.training;

import com.smalaca.trainingplanner.domain.training.Period;
import com.smalaca.trainingplanner.domain.training.Training;
import com.smalaca.trainingplanner.domain.training.TrainingRepository;
import com.smalaca.trainingplanner.domain.training.TrainingType;
import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository repository;

    TrainingApplicationService(TrainingRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void schedule(CreateTrainingCommand command) {
        TrainingCode trainingCode = new TrainingCode(command.trainingCode());
        Period period = new Period(command.start(), command.end());
        TrainingType trainingType = TrainingType.valueOf(command.trainingType());
        CreateTrainingDomainCommand domainCommand = new CreateTrainingDomainCommand(trainingCode, period, trainingType);

        Training training = new Training(domainCommand);

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
