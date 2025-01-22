package com.smalaca.trainingmanagement.domain.trainingidea;

import com.smalaca.trainingmanagement.domain.eventregistry.EventRegistry;
import com.smalaca.trainingmanagement.domain.trainingidea.events.TrainingIdeaRegistered;

import java.util.List;
import java.util.UUID;

public class TrainingIdeaFactory {
    private final TrainingIdeaRepository repository;
    private final EventRegistry eventRegistry;

    TrainingIdeaFactory(TrainingIdeaRepository repository, EventRegistry eventRegistry) {
        this.repository = repository;
        this.eventRegistry = eventRegistry;
    }

    public TrainingIdea create(UUID trainerId, String name) {
        // option 1 - if performance is not good
//        boolean exists = repository.doesExistNotValidatedIdeaFor(trainerId, name);

        // option 2
        List<TrainingIdea> ideas = repository.findAllBy(trainerId, name);
        if (anyNotValidated(ideas)) {
            throw new AlreadyExistingTrainingIdeaException(trainerId, name);
        }

        eventRegistry.publish(TrainingIdeaRegistered.create(trainerId, name));
        return new TrainingIdea(trainerId, name);
    }

    private boolean anyNotValidated(List<TrainingIdea> ideas) {
        return ideas.stream().anyMatch(TrainingIdea::isNotValidated);
    }
}
