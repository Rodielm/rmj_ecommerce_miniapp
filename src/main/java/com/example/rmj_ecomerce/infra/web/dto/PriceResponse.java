package com.example.rmj_ecomerce.infra.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(
        int productId,
        int brandId,
        int priceList,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal price,
        String currency) {}
