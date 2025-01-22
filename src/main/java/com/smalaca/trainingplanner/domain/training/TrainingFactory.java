package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;

import java.util.List;

public class TrainingFactory {
    private final TrainingRepository trainingRepository;

    TrainingFactory(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training create(CreateTrainingDomainCommand command) {
        if (command.period().lastLongerThanDays(5)) {
            throw TrainingException.tooLong(command.trainingDefinitionId(), command.period());
        }

        if (alreadyScheduledFor(command)) {
            throw TrainingException.alreadyScheduled(command.trainingDefinitionId(), command.period());
        }

        return new Training(command);
    }

    private boolean alreadyScheduledFor(CreateTrainingDomainCommand command) {
        List<Training> trainings = trainingRepository.findFor(command.trainingDefinitionId());
        return trainings.stream()
                .anyMatch(training -> training.withinTheSame(command.period()));
    }
}
