package com.example.rmj_ecomerce.infra.web.mapper;

import org.springframework.stereotype.Component;

import com.example.rmj_ecomerce.domain.Price;
import com.example.rmj_ecomerce.infra.web.dto.PriceResponse;

@Component
public class PriceResponseMapper {
    public PriceResponse toResponse(Price price) {
        return new PriceResponse(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice(),
                price.getCurrency());
    }
}
