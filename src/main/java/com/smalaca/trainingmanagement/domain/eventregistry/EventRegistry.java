package com.smalaca.trainingmanagement.domain.eventregistry;

import com.smalaca.trainingmanagement.domain.trainingidea.events.TrainingIdeaRegistered;

public interface EventRegistry {
    void publish(TrainingIdeaRegistered trainingIdeaRegistered);
}
