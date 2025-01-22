package com.smalaca.trainingsale.domain.offer;

import java.util.UUID;

public interface OfferRepository {
    Offer findById(UUID offerId);

    void save(Offer offer);
}
