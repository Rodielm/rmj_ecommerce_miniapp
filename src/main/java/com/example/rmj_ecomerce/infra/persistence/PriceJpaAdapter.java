package com.example.rmj_ecomerce.infra.persistence;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.rmj_ecomerce.application.port.out.LoadPricePort;
import com.example.rmj_ecomerce.domain.Price;
import com.example.rmj_ecomerce.infra.persistence.mapper.PriceMapper;
import com.example.rmj_ecomerce.infra.persistence.repo.JpaPriceRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceJpaAdapter implements LoadPricePort {
    private final JpaPriceRepo priceRepo;
    private final PriceMapper priceMapper;

    @Override
    public Optional<Price> loadPrice(int productId, int brandId, LocalDateTime appDate) {
        return priceRepo
                .findTopByProductIdAndBrandIdAndDateOrderByPriorityDesc(productId, brandId, appDate)
                .map(priceMapper::toDomain);
    }

}
