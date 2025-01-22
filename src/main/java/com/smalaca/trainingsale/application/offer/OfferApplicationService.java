package com.smalaca.trainingsale.application.offer;

import com.smalaca.trainingsale.domain.offer.Offer;
import com.smalaca.trainingsale.domain.offer.OfferRepository;
import com.smalaca.trainingsale.domain.order.Order;
import com.smalaca.trainingsale.domain.order.OrderRepository;
import com.smalaca.trainingsale.domain.trainingplanner.TrainingPlanner;

import java.util.UUID;

public class OfferApplicationService {
    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;
    private final TrainingPlanner trainingPlanner;

    OfferApplicationService(OfferRepository offerRepository, OrderRepository orderRepository, TrainingPlanner trainingPlanner) {
        this.offerRepository = offerRepository;
        this.orderRepository = orderRepository;
        this.trainingPlanner = trainingPlanner;
    }

    public void accept(UUID offerId) {
        Offer offer = offerRepository.findById(offerId);

        Order order = offer.accept(trainingPlanner);

        offerRepository.save(offer);
        orderRepository.save(order);
    }
}
