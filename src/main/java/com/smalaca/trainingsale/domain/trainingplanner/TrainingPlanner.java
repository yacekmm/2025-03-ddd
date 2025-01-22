package com.smalaca.trainingsale.domain.trainingplanner;

import java.util.UUID;

public interface TrainingPlanner {
    boolean book(UUID trainingId);
}
