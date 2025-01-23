package com.example.rmj_ecomerce.infra.web;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rmj_ecomerce.application.port.in.GetPriceQuery;
import com.example.rmj_ecomerce.application.port.in.GetPriceUseCase;
import com.example.rmj_ecomerce.infra.web.dto.PriceResponse;
import com.example.rmj_ecomerce.infra.web.mapper.PriceResponseMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/prices")
@RequiredArgsConstructor
@Tag(name = "Prices API", description = "API for retrieving product prices")
public class PriceCtrl {

    private final GetPriceUseCase getPriceUseCase;
    private final PriceResponseMapper mapper;

    @GetMapping
    @Operation(summary = "Get price for a product at a specific date")
    ResponseEntity<PriceResponse> getPrice(
            @Parameter(description = "Application date", required = true) @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @Parameter(description = "Product ID", required = true) @RequestParam int productId,
            @Parameter(description = "Brand ID", required = true) @RequestParam int brandId) {
        GetPriceQuery query = new GetPriceQuery(productId, brandId, applicationDate);

        return getPriceUseCase.getPrice(query)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
