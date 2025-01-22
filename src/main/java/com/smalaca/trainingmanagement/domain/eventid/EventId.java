package com.smalaca.trainingmanagement.domain.eventid;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventId(UUID eventId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
    public static EventId createNew() {
        return new EventId(randomId(), randomId(), randomId(), LocalDateTime.now());
    }

    private static UUID randomId() {
        return UUID.randomUUID();
    }
}
