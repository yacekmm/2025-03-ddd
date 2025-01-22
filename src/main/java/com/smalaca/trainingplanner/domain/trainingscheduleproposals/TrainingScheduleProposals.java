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
        add(participantId, TrainingProposal.create(participantId));
    }

    public void proposeSlot(UUID participantId, Period period) {
        add(participantId, TrainingProposal.create(participantId, period));
    }

    private void add(UUID participantId, TrainingProposal trainingProposal) {
        if (hasProposalFor(participantId)) {
            throw new AlreadyRegisteredProposalException(participantId);
        }

        proposals.add(trainingProposal);
    }

    private boolean hasProposalFor(UUID participantId) {
        return proposals.stream()
                .anyMatch(existingProposal -> existingProposal.isFor(participantId));
    }
}
