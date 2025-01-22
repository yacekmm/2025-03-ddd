package com.smalaca.trainingplanner.infrastructure.adapter.driving.rest.training;

import java.util.UUID;

public record BookingDto(UUID trainingId, UUID participantId) {
}
