package com.smalaca.trainingplanner.domain.training;

import java.time.LocalDate;

// value object
public class Period {
    private final LocalDate start;
    private final LocalDate end;

    public Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
}
