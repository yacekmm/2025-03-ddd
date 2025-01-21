package com.smalaca.trainingplanner.infrastructure.adapter.driving.rest.training;

import com.smalaca.trainingplanner.application.training.TrainingApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
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

    @PutMapping("/move")
    public void move(UUID trainingId) {
        service.move(trainingId);
    }

    @PutMapping("/cancel")
    public void cancel(UUID trainingId) {
        service.cancel(trainingId);
    }
}
