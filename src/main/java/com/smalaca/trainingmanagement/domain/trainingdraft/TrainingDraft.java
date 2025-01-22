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
        if (command.categories().size() < 1) {
            throw new MissingCategoriesException(number);
        }

        categories = command.categories();
        trainingDays = command.trainingDays();
        price = command.price();
        description = command.description();
    }
}
