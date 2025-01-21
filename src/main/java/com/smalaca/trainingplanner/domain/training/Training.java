package com.smalaca.trainingplanner.domain.training;

import com.smalaca.trainingplanner.domain.trainingcode.TrainingCode;

// aggregate root
public class Training {
    private TrainingCode trainingCode;
    private Period period;

    public void move() {

    }

    public void cancel() {

    }
}
