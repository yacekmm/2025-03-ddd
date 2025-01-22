package com.smalaca.trainingplanner.application.training;

import com.smalaca.trainingplanner.domain.period.Period;
import com.smalaca.trainingplanner.domain.training.Training;
import com.smalaca.trainingplanner.domain.training.TrainingFactory;
import com.smalaca.trainingplanner.domain.training.TrainingRepository;
import com.smalaca.trainingplanner.domain.training.TrainingType;
import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class TrainingApplicationService {
    private final TrainingRepository repository;
    private final TrainingFactory trainingFactory;

    TrainingApplicationService(TrainingRepository repository, TrainingFactory trainingFactory) {
        this.repository = repository;
        this.trainingFactory = trainingFactory;
    }

    @Transactional
    public void schedule(CreateTrainingCommand command) {
        TrainingCode trainingCode = new TrainingCode(command.trainingCode());
        Period period = Period.create(command.start(), command.end());
        TrainingType trainingType = TrainingType.create(command.trainingType());
        CreateTrainingDomainCommand domainCommand = new CreateTrainingDomainCommand(command.trainingDefinitionId(), trainingCode, period, trainingType);

        Training training = trainingFactory.create(domainCommand);

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

    @Transactional
    public void book(UUID trainingId, UUID participantId) {
        Training training = repository.findById(trainingId);

        training.book(participantId);

        repository.save(training);
    }
}
