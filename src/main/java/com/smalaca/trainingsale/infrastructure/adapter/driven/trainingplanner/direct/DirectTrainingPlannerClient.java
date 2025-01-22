package com.smalaca.trainingsale.infrastructure.adapter.driven.trainingplanner.direct;

import com.smalaca.trainingplanner.application.training.TrainingApplicationService;
import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;

import java.util.UUID;

public class DirectTrainingPlannerClient implements TrainingPlanner {
    private final TrainingApplicationService trainingApplicationService;

    DirectTrainingPlannerClient(TrainingApplicationService trainingApplicationService) {
        this.trainingApplicationService = trainingApplicationService;
    }

    @Override
    public boolean book(UUID trainingId, UUID participantId) {
        // TRANSACTIONALITY!!!
        try {
            trainingApplicationService.book(trainingId, participantId);
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public Price priceOf(UUID trainingId) {
        return null;
    }
}
