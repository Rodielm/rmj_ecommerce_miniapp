package com.example.rmj_ecomerce.application.port.in;

import java.util.Optional;

import com.example.rmj_ecomerce.domain.Price;

public interface GetPriceUseCase {
    Optional<Price> getPrice(GetPriceQuery query);
}
