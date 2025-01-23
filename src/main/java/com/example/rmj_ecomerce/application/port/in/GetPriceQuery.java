package com.example.rmj_ecomerce.application.port.in;

import java.time.LocalDateTime;

public record GetPriceQuery(
        int productId,
        int brandId,
        LocalDateTime applicationDate) {}
