package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

// aggregate root
public class Training {
    private final TrainingType trainingType;
    private TrainingCode trainingCode;
    private Period period;

    public Training(CreateTrainingDomainCommand command) {
        trainingCode = command.trainingCode();
        period = command.period();
        trainingType = command.trainingType();
    }

    public void move() {

    }

    public void cancel() {

    }
}
