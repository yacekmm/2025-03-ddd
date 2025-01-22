package com.smalaca.trainingplanner.domain.period;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// value object
public class Period {
    private final LocalDate start;
    private final LocalDate end;

    private Period(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public static Period create(LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            throw new InvalidPeriodException(start, end);
        }

        return new Period(start, end);
    }

    public boolean lastLongerThanDays(int days) {
        long diffInDays = start.until(end, ChronoUnit.DAYS);
        return diffInDays > days;
    }
}
