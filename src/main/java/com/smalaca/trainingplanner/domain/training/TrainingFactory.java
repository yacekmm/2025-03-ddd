package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;

public class TrainingFactory {
    public Training create(CreateTrainingDomainCommand command) {
        if (command.period().lastLongerThanDays(5)) {
            throw TrainingException.tooLong(command.period());
        }

        return new Training(command);
    }
}
