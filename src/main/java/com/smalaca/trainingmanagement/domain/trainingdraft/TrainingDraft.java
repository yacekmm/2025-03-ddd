package com.smalaca.trainingmanagement.domain.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingmanagement.domain.trainingdraft.commands.AddTrainingDraftDetailsDomainCommand;

import java.util.List;
import java.util.UUID;

// aggregate root
public class TrainingDraft {
//    private TrainersCatalogue trainersCatalogue;

    private TrainingDraftNumber number;
    private TrainingDays trainingDays;
    private Price price;
    private String description;
    private List<String> categories;

    public void addDetails(AddTrainingDraftDetailsDomainCommand command, TrainersCatalogue trainersCatalogue) {
        if (cannotBeTrainingGuardian(trainersCatalogue, command.trainerId())) {
            throw new InvalidTrainingGuardingException(command.trainerId());
        }

        if (command.categories().size() < 1) {
            throw new MissingCategoriesException(number);
        }

        categories = command.categories();
        trainingDays = command.trainingDays();
        price = command.price();
        description = command.description();
    }

    private boolean cannotBeTrainingGuardian(TrainersCatalogue trainersCatalogue, UUID trainerId) {
        return !trainersCatalogue.canBeTrainingGuardian(trainerId);
    }
}
