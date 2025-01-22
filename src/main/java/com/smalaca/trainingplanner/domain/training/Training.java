package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.period.Period;
import com.smalaca.trainingplanner.domain.training.commands.CreateTrainingDomainCommand;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

import java.util.UUID;

// aggregate root
public class Training {
    private UUID trainingDefinitionId;
    private TrainingType trainingType;
    private TrainingCode trainingCode;
    private Period period;

    public Training(CreateTrainingDomainCommand command) {
        trainingDefinitionId = command.trainingDefinitionId();
        trainingCode = command.trainingCode();
        period = command.period();
        trainingType = command.trainingType();
    }

    public void move() {
        // TBD
    }

    public void cancel() {
        // TBD
    }

    boolean withinTheSame(Period period) {
        return this.period.withinTheSame(period);
    }

    public void book(UUID participantId) {
        // TBD
    }
}
