package com.example.rmj_ecomerce.infra.persistence.mapper;

import org.springframework.stereotype.Component;

import com.example.rmj_ecomerce.domain.Price;
import com.example.rmj_ecomerce.infra.persistence.entity.PriceEntity;

@Component
public class PriceMapper {
 public Price toDomain(PriceEntity entity) {
        return Price.builder()
            .productId(entity.getProductId())
            .brandId(entity.getBrandId())
            .priceList(entity.getPriceList())
            .startDate(entity.getStartDate())
            .endDate(entity.getEndDate())
            .price(entity.getPrice())
            .currency(entity.getCurr())
            .build();
    }
}
