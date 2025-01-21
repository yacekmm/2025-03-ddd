package com.smalaca.trainingmanagement.application.trainingdraft;

import com.smalaca.trainingmanagement.domain.trainingdraft.AddTrainingDraftDetailsDomainCommand;
import com.smalaca.trainingmanagement.domain.trainingdraft.Price;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDays;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraftRepository;
import org.springframework.transaction.annotation.Transactional;

public class TrainingDraftApplicationService {
    private final TrainingDraftRepository repository;

    TrainingDraftApplicationService(TrainingDraftRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addDetails(AddTrainingDraftDetailsCommand command) {
        TrainingDraft trainingDraft = repository.findById(command.trainingDraftId());
        Price price = new Price(command.price());
        TrainingDays trainingDays = new TrainingDays(command.trainingDays());
        AddTrainingDraftDetailsDomainCommand domainCommand = new AddTrainingDraftDetailsDomainCommand(price, trainingDays, command.description());

        trainingDraft.addDetails(domainCommand);

        repository.save(trainingDraft);
    }
}
