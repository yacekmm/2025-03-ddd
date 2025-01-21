package com.smalaca.trainingplanner.domain.trainingscheduleproposals;

import java.util.UUID;

public interface TrainingScheduleProposalsRepository {
    TrainingScheduleProposals findByTrainingId(UUID trainingId);

    void save(TrainingScheduleProposals trainingScheduleProposals);
}
