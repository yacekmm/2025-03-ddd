package com.smalaca.trainingsale.infrastructure.adapter.driven.trainingplanner.rest;

import java.util.UUID;

public record BookingRequest(UUID trainingId, UUID participantId) {
}
