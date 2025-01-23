package com.example.rmj_ecomerce.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Price {
    int productId;
    int brandId;
    int priceList;
    LocalDateTime startDate;
    LocalDateTime endDate;
    BigDecimal price;
    String currency;

    public boolean isValidForDate(LocalDateTime date) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

}
