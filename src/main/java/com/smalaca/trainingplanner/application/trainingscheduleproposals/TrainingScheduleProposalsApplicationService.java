package com.smalaca.trainingplanner.application.trainingscheduleproposals;

import com.smalaca.trainingplanner.domain.trainingscheduleproposals.TrainingScheduleProposals;
import com.smalaca.trainingplanner.domain.trainingscheduleproposals.TrainingScheduleProposalsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class TrainingScheduleProposalsApplicationService {
    private final TrainingScheduleProposalsRepository repository;

    public TrainingScheduleProposalsApplicationService(TrainingScheduleProposalsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void signForTraining(UUID trainingId) {
        TrainingScheduleProposals trainingScheduleProposals = repository.findByTrainingId(trainingId);

        trainingScheduleProposals.sign();

        repository.save(trainingScheduleProposals);
    }

    @Transactional
    public void proposeSlotForTraining(UUID trainingId) {
        TrainingScheduleProposals trainingScheduleProposals = repository.findByTrainingId(trainingId);

        trainingScheduleProposals.proposeSlot();

        repository.save(trainingScheduleProposals);
    }
}
