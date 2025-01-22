package com.smalaca.trainingmanagement.domain.trainingdraft;

import java.math.BigDecimal;

public class IncorrectPriceException extends RuntimeException {
    private final BigDecimal decimal;

    IncorrectPriceException(BigDecimal price) {
        this.decimal = price;
    }
}
