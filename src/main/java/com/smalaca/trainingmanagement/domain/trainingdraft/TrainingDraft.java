package com.smalaca.trainingmanagement.domain.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainingdraft.commands.AddTrainingDraftDetailsDomainCommand;

// aggregate root
public class TrainingDraft {
    private TrainingDraftNumber number;
    private TrainingDays trainingDays;
    private Price price;
    private String description;

    public void addDetails(AddTrainingDraftDetailsDomainCommand command) {
        trainingDays = command.trainingDays();
        price = command.price();
        description = command.description();
    }
}
