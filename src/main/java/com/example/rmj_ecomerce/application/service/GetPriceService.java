package com.example.rmj_ecomerce.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rmj_ecomerce.application.port.in.GetPriceQuery;
import com.example.rmj_ecomerce.application.port.in.GetPriceUseCase;
import com.example.rmj_ecomerce.application.port.out.LoadPricePort;
import com.example.rmj_ecomerce.domain.Price;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPriceService implements GetPriceUseCase {
    private final LoadPricePort loadPricePort;

    @Override
    @Transactional(readOnly = true)
    public Optional<Price> getPrice(GetPriceQuery query) {
        return loadPricePort.loadPrice(
                query.productId(),
                query.brandId(),
                query.applicationDate());
    }

}
