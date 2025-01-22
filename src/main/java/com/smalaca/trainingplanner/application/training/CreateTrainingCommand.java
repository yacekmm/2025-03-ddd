package com.smalaca.trainingplanner.application.training;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTrainingCommand(UUID trainingDefinitionId, String trainingCode, LocalDate start, LocalDate end, String trainingType) {
}
