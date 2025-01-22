package com.smalaca.trainingplanner.application.trainingscheduleproposals;

import com.smalaca.trainingplanner.domain.period.Period;
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
    public void signForTraining(UUID trainingScheduleProposalsId, UUID participantId) {
        TrainingScheduleProposals trainingScheduleProposals = repository.findById(trainingScheduleProposalsId);

        trainingScheduleProposals.sign(participantId);

        repository.save(trainingScheduleProposals);
    }

    @Transactional
    public void proposeSlotForTraining(ProposeSlotForTrainingCommand command) {
        TrainingScheduleProposals trainingScheduleProposals = repository.findById(command.trainingScheduleProposalsId());
        Period period = Period.create(command.start(), command.end());

        trainingScheduleProposals.proposeSlot(command.participantId(), period);

        repository.save(trainingScheduleProposals);
    }
}
