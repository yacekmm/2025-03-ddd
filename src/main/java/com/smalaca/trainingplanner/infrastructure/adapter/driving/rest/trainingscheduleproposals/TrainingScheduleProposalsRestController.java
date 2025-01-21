package com.smalaca.trainingplanner.infrastructure.adapter.driving.rest.trainingscheduleproposals;

import com.smalaca.trainingplanner.application.trainingscheduleproposals.TrainingScheduleProposalsApplicationService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/training-schedule-proposal")
public class TrainingScheduleProposalsRestController {
    private final TrainingScheduleProposalsApplicationService service;

    TrainingScheduleProposalsRestController(TrainingScheduleProposalsApplicationService service) {
        this.service = service;
    }

    @PutMapping("/sign")
    public void signForTraining(UUID trainingId) {
        service.signForTraining(trainingId);
    }

    @PutMapping("/propose")
    public void proposeSlotForTraining(UUID trainingId) {
        service.proposeSlotForTraining(trainingId);
    }
}
