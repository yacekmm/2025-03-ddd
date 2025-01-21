package com.smalaca.trainingmanagement.application.trainingidea;

import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraft;
import com.smalaca.trainingmanagement.domain.trainingdraft.TrainingDraftRepository;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdea;
import com.smalaca.trainingmanagement.domain.trainingidea.TrainingIdeaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class TrainingIdeaApplicationService {
    private final TrainingIdeaRepository trainingIdeaRepository;
    private final TrainingDraftRepository trainingDraftRepository;

    TrainingIdeaApplicationService(TrainingIdeaRepository trainingIdeaRepository, TrainingDraftRepository trainingDraftRepository) {
        this.trainingIdeaRepository = trainingIdeaRepository;
        this.trainingDraftRepository = trainingDraftRepository;
    }

    @Transactional
    public void register() {
        // tłumaczenie na język biznesowy [0...*]

        // delegacja do domeny [1]
        TrainingIdea trainingIdea = new TrainingIdea();

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
