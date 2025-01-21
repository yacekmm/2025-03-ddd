package com.smalaca.trainingplanner.infrastructure.adapter.driving.rest.training;

import com.smalaca.trainingplanner.application.training.TrainingApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/training")
public class TrainingRestController {
    private final TrainingApplicationService service;

    TrainingRestController(TrainingApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public void book() {
        service.book();
    }
}
