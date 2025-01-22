package com.smalaca.trainingplanner.domain.training.commands;

import com.smalaca.trainingplanner.domain.training.Period;
import com.smalaca.trainingplanner.domain.training.TrainingType;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

import java.time.LocalDate;

public record CreateTrainingDomainCommand(TrainingCode trainingCode, Period period, TrainingType trainingType) {
}
