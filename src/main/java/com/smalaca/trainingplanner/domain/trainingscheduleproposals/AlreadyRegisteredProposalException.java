package com.smalaca.trainingplanner.domain.trainingscheduleproposals;

import java.util.UUID;

public class AlreadyRegisteredProposalException extends RuntimeException {
    private final UUID participantId;

    AlreadyRegisteredProposalException(UUID participantId) {
        this.participantId = participantId;
    }
}
