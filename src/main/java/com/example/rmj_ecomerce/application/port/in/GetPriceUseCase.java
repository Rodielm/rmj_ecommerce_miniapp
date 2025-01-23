package com.example.rmj_ecomerce.application.port.in;

import com.example.rmj_ecomerce.domain.Price;
import com.example.rmj_ecomerce.domain.exception.PriceNotFoundException;

public interface GetPriceUseCase {
    Price getPrice(GetPriceQuery query) throws PriceNotFoundException;;
}
