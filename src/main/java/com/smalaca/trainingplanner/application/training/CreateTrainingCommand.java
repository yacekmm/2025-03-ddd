package com.smalaca.trainingplanner.application.training;

import java.time.LocalDate;

public record CreateTrainingCommand(String trainingCode, LocalDate start, LocalDate end, String trainingType) {
}
