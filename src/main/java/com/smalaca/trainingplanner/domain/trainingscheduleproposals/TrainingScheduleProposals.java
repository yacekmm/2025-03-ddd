package com.smalaca.trainingplanner.domain.trainingscheduleproposals;

import com.smalaca.trainingplanner.domain.period.Period;
import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// aggregate root
public class TrainingScheduleProposals {
    private TrainingCode trainingCode;
    private List<TrainingProposal> proposals = new ArrayList<>();

    public void sign(UUID participantId) {
        proposals.add(TrainingProposal.create(participantId));
    }

    public void proposeSlot(UUID participantId, Period period) {
        proposals.add(TrainingProposal.create(participantId, period));
    }
}
