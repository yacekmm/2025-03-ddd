package com.smalaca.trainingmanagement.domain.trainingdraft.commands;

import com.smalaca.trainingmanagement.domain.trainingdraft.Price;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDays;

import java.util.List;
import java.util.UUID;

public record AddTrainingDraftDetailsDomainCommand(
        UUID trainerId, Price price, TrainingDays trainingDays, String description, List<String> categories) {
}
