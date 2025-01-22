package com.smalaca.trainingmanagement.domain.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainingdraft.commands.AddTrainingDraftDetailsDomainCommand;

import java.util.List;

// aggregate root
public class TrainingDraft {
    private TrainingDraftNumber number;
    private TrainingDays trainingDays;
    private Price price;
    private String description;
    private List<String> categories;

    public void addDetails(AddTrainingDraftDetailsDomainCommand command) {
        trainingDays = command.trainingDays();
        price = command.price();
        description = command.description();
        categories = command.categories();
    }
}
