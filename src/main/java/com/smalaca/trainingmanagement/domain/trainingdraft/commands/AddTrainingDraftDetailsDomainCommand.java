package com.smalaca.trainingmanagement.domain.trainingdraft.commands;

import com.smalaca.trainingmanagement.domain.trainingdraft.Price;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDays;

import java.util.List;

public record AddTrainingDraftDetailsDomainCommand(Price price, TrainingDays trainingDays, String description, List<String> categories) {
}
