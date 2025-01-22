package com.smalaca.trainingmanagement.domain.trainingdraft;

import java.math.BigDecimal;

// value object
public class Price {
    private final BigDecimal price;

    public Price(BigDecimal price) {
        this.price = price;
    }
}
