package com.smalaca.trainingmanagement.infrastructure.adapter.driving.rest.trainingidea;

import com.smalaca.trainingmanagement.application.trainingidea.TrainingIdeaApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/training-idea")
public class TrainingIdeaRestController {
    private final TrainingIdeaApplicationService service;

    TrainingIdeaRestController(TrainingIdeaApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public void register() {
        service.register();
    }

    @PutMapping("/accept")
    public void accept(UUID trainingIdeaId) {
        service.accept(trainingIdeaId);
    }
}
