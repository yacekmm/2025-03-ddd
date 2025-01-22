package com.smalaca.trainingplanner.application.trainingscheduleproposals;

import java.time.LocalDate;
import java.util.UUID;

public record ProposeSlotForTrainingCommand(UUID trainingScheduleProposalsId, UUID participantId, LocalDate start, LocalDate end) {
}
