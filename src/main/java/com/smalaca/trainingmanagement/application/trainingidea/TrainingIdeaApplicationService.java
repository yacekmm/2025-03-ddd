package com.smalaca.trainingmanagement.application.trainingidea;

import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdea;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdeaRepository;
import org.springframework.transaction.annotation.Transactional;

public class TrainingIdeaApplicationService {
    private final TrainingIdeaRepository repository;

    TrainingIdeaApplicationService(TrainingIdeaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void register() {
        // tłumaczenie na język biznesowy [0...*]

        // delegacja do domeny [1]
        TrainingIdea trainingIdea = new TrainingIdea();

        // zapisanie zmian [1...*]
        repository.save(trainingIdea);
    }
}
