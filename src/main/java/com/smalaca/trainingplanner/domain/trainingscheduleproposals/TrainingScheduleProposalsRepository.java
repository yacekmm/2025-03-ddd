package com.smalaca.trainingplanner.domain.trainingscheduleproposals;

import java.util.UUID;

public interface TrainingScheduleProposalsRepository {
    TrainingScheduleProposals findById(UUID trainingId);

    void save(TrainingScheduleProposals trainingScheduleProposals);
}
