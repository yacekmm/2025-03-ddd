package com.smalaca.trainingmanagement.domain.trainingdraft;

import java.math.BigDecimal;

// value object
public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    // factory
    public static Price create(BigDecimal price) {
        if (isNegative(price)) {
            throw new IncorrectPriceException(price);
        }

        return new Price(price);
    }

    private static boolean isNegative(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) > 0;
    }
}
