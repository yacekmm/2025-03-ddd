package com.smalaca.trainingmanagement.application.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainerscatalogue.TrainersCatalogue;
import com.smalaca.trainingmanagement.domain.trainingdraft.Price;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDays;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraftRepository;
import com.smalaca.trainingmanagement.domain.trainingdraft.commands.AddTrainingDraftDetailsDomainCommand;
import org.springframework.transaction.annotation.Transactional;

public class TrainingDraftApplicationService {
    private final TrainingDraftRepository repository;
    private final TrainersCatalogue trainersCatalogue;

    TrainingDraftApplicationService(TrainingDraftRepository repository, TrainersCatalogue trainersCatalogue) {
        this.repository = repository;
        this.trainersCatalogue = trainersCatalogue;
    }

    @Transactional
    public void addDetails(AddTrainingDraftDetailsCommand command) {
//    public void addDetails(UUID trainingDraftId, AddTrainingDraftDetailsDomainCommand command) {
        // tłumaczenie
        TrainingDraft trainingDraft = repository.findById(command.trainingDraftId());
        Price price = Price.create(command.price());
        TrainingDays trainingDays = new TrainingDays(command.trainingDays());
        AddTrainingDraftDetailsDomainCommand domainCommand = new AddTrainingDraftDetailsDomainCommand(
                command.trainerId(), price, trainingDays, command.description(), command.categories());

        // akcja z domeny
        trainingDraft.addDetails(domainCommand, trainersCatalogue);

        // zapisanie do repository
        repository.save(trainingDraft);
    }
}
