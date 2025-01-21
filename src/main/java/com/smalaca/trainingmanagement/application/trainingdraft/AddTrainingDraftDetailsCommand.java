package com.smalaca.trainingmanagement.application.trainingdraft;

import java.math.BigDecimal;
import java.util.UUID;

record AddTrainingDraftDetailsCommand(UUID trainingDraftId, BigDecimal price, int trainingDays, String description) {
}
