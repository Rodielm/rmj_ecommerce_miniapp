package com.example.rmj_ecomerce.application.port.out;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.rmj_ecomerce.domain.Price;

public interface LoadPricePort {
    Optional<Price> loadPrice(int productId, int brandId, LocalDateTime applicationDate);
}
