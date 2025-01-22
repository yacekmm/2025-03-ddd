package com.smalaca.trainingmanagement.domain.trainingidea;

import java.util.List;
import java.util.UUID;

public class TrainingIdeaFactory {
    private final TrainingIdeaRepository repository;

    TrainingIdeaFactory(TrainingIdeaRepository repository) {
        this.repository = repository;
    }

    public TrainingIdea create(UUID trainerId, String name) {
        // option 1 - if performance is not good
//        boolean exists = repository.doesExistNotValidatedIdeaFor(trainerId, name);

        // option 2
        List<TrainingIdea> ideas = repository.findAllBy(trainerId, name);
        if (anyNotValidated(ideas)) {
            throw new AlreadyExistingTrainingIdeaException(trainerId, name);
        }

        return new TrainingIdea(trainerId, name);
    }

    private boolean anyNotValidated(List<TrainingIdea> ideas) {
        return ideas.stream().anyMatch(TrainingIdea::isNotValidated);
    }
}
