package com.smalaca.trainingmanagement.infrastructure.adapter.driving.rest.trainingidea;

import com.smalaca.trainingmanagement.application.trainingidea.TrainingIdeaApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/training-idea")
public class TrainingIdeaRestController {
    private final TrainingIdeaApplicationService service;

    TrainingIdeaRestController(TrainingIdeaApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public void register(UUID trainerId, String name) {
        service.register(trainerId, name);
    }

    @PutMapping("/accept")
    public void accept(UUID trainingIdeaId) {
        service.accept(trainingIdeaId);
    }
}
