package com.smalaca.trainingplanner.domain.trainingscheduleproposals;

import com.smalaca.trainingplanner.domain.period.Period;

import java.util.UUID;

// entity? value object?
class TrainingProposal {
    private static final Period NO_PERIOD = null;

    private final UUID participantId;
    private final Period period;

    private TrainingProposal(UUID participantId, Period period) {
        this.participantId = participantId;
        this.period = period;
    }

    static TrainingProposal create(UUID participantId) {
        return new TrainingProposal(participantId, NO_PERIOD);
    }

    static TrainingProposal create(UUID participantId, Period period) {
        return new TrainingProposal(participantId, period);
    }
}
