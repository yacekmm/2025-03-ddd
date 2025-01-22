package com.smalaca.trainingmanagement.application.trainingdraft;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

record AddTrainingDraftDetailsCommand(UUID trainingDraftId, UUID trainerId,  BigDecimal price, int trainingDays, String description, List<String> categories) {
}
