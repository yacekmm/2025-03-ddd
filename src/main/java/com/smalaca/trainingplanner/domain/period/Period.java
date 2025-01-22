package com.smalaca.trainingplanner.domain.period;

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
