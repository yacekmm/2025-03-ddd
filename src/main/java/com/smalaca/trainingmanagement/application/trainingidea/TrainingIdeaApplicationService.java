package com.smalaca.trainingmanagement.application.trainingidea;

import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraftRepository;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdea;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdeaFactory;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdeaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class TrainingIdeaApplicationService {
    private final TrainingIdeaRepository trainingIdeaRepository;
    private final TrainingDraftRepository trainingDraftRepository;
    private final TrainingIdeaFactory trainingIdeaFactory;

    TrainingIdeaApplicationService(TrainingIdeaRepository trainingIdeaRepository, TrainingDraftRepository trainingDraftRepository, TrainingIdeaFactory trainingIdeaFactory) {
        this.trainingIdeaRepository = trainingIdeaRepository;
        this.trainingDraftRepository = trainingDraftRepository;
        this.trainingIdeaFactory = trainingIdeaFactory;
    }

    @Transactional
    public void register(UUID trainerId, String name) {
        // tłumaczenie na język biznesowy [0...*]

        // delegacja do domeny [1]
        TrainingIdea trainingIdea = trainingIdeaFactory.create(trainerId, name);

        // zapisanie zmian [1...*]
        trainingIdeaRepository.save(trainingIdea);
    }

    @Transactional
    public void accept(UUID trainingIdeaId) {
        // tłumaczenie na język biznesowy [0...*]
        TrainingIdea trainingIdea = trainingIdeaRepository.findById(trainingIdeaId);

        // delegacja do domeny [1]
        TrainingDraft draft = trainingIdea.accept();

        // zapisanie zmian [1...*]
        trainingIdeaRepository.save(trainingIdea);
        trainingDraftRepository.save(draft);
    }
}
