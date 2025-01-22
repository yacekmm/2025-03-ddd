package com.smalaca.trainingmanagement.domain.trainingidea.events;

import com.smalaca.trainingmanagement.domain.eventid.EventId;

import java.util.UUID;

public record TrainingIdeaRegistered(EventId eventId, UUID trainerId, String name) {
    public static TrainingIdeaRegistered create(UUID trainerId, String name) {
        return new TrainingIdeaRegistered(EventId.createNew(), trainerId, name);
    }
}
