package com.smalaca.trainingmanagement.domain.trainingdraft;

public record AddTrainingDraftDetailsDomainCommand(Price price, TrainingDays trainingDays, String description) {
}
