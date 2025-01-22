package com.smalaca.trainingplanner.domain.training.commands;

import com.smalaca.trainingplanner.domain.period.Period;
import com.smalaca.trainingplanner.domain.training.TrainingType;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

import java.util.UUID;

public record CreateTrainingDomainCommand(UUID trainingDefinitionId, TrainingCode trainingCode, Period period, TrainingType trainingType) {
}
