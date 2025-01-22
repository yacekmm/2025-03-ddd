package com.smalaca.trainingmanagement.domain.trainerscatalogue;

import java.util.UUID;

public interface TrainersCatalogue {
    boolean canBeTrainingGuardian(UUID trainerId);
}
