package com.smalaca.trainingplanner.domain.period;

import java.time.LocalDate;

public class InvalidPeriodException extends RuntimeException {
    private final LocalDate start;
    private final LocalDate end;

    InvalidPeriodException(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
}
