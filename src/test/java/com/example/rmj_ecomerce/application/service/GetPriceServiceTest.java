package com.example.rmj_ecomerce.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.rmj_ecomerce.application.port.in.GetPriceQuery;
import com.example.rmj_ecomerce.application.port.out.LoadPricePort;
import com.example.rmj_ecomerce.domain.Price;

@ExtendWith(MockitoExtension.class)
public class GetPriceServiceTest {
    @Mock
    private LoadPricePort loadPricePort;

    @InjectMocks
    private GetPriceService getPriceService;

    @Test
    void shouldReturnPriceWhenExists() {
        // Given
        LocalDateTime appDate = LocalDateTime.parse("2020-06-14T10:00:00");
        GetPriceQuery query = new GetPriceQuery(35455, 1, appDate);

        Price expectedPrice = Price.builder()
                .productId(35455)
                .brandId(1)
                .priceList(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price(new BigDecimal("35.50"))
                .currency("EUR")
                .build();

        when(loadPricePort.loadPrice(eq(35455), eq(1), any()))
                .thenReturn(Optional.of(expectedPrice));

        // When
        Optional<Price> result = getPriceService.getPrice(query);

        // Then
        assertTrue(result.isPresent());
        Price price = result.get();
        assertEquals(expectedPrice.getProductId(), price.getProductId());
        assertEquals(expectedPrice.getBrandId(), price.getBrandId());
        assertEquals(expectedPrice.getPrice(), price.getPrice());
        assertEquals(expectedPrice.getCurrency(), price.getCurrency());
    }


    @Test
    void shouldReturnEmptyWhenNoPriceExists() {
        // Given
        LocalDateTime appDate = LocalDateTime.parse("2020-06-14T10:00:00");
        GetPriceQuery query = new GetPriceQuery(35455, 1, appDate);
        
        when(loadPricePort.loadPrice(eq(35455), eq(1), any()))
            .thenReturn(Optional.empty());

        // When
        Optional<Price> result = getPriceService.getPrice(query);

        // Then
        assertTrue(result.isEmpty());
    }
}
