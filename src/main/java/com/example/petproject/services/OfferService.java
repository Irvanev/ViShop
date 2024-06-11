package com.example.petproject.services;

import com.example.petproject.dtos.offers.OfferDto;

public interface OfferService {
    Iterable<OfferDto> allOffers();
    OfferDto addOffer(OfferDto offer);
}
