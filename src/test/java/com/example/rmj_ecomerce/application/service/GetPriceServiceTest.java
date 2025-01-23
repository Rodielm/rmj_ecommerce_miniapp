package com.example.rmj_ecomerce.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.example.rmj_ecomerce.domain.exception.PriceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class GetPriceServiceTest {
    @Mock
    private LoadPricePort loadPricePort;

    @InjectMocks
    private GetPriceService getPriceService;

    @Test
    void shouldReturnPriceWhenExists() throws PriceNotFoundException {
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
        Price result = getPriceService.getPrice(query);

        // Then
        assertEquals(expectedPrice.getProductId(), result.getProductId());
        assertEquals(expectedPrice.getBrandId(), result.getBrandId());
        assertEquals(expectedPrice.getPriceList(), result.getPriceList());
        assertEquals(expectedPrice.getStartDate(), result.getStartDate());
        assertEquals(expectedPrice.getEndDate(), result.getEndDate());
        assertEquals(expectedPrice.getPrice(), result.getPrice());
        assertEquals(expectedPrice.getCurrency(), result.getCurrency());
    }

    @Test
    void shouldThrowPriceNotFoundExceptionWhenPriceDoesNotExist() {
        // Given
        LocalDateTime appDate = LocalDateTime.parse("2020-06-14T10:00:00");
        GetPriceQuery query = new GetPriceQuery(35455, 1, appDate);

        when(loadPricePort.loadPrice(eq(35455), eq(1), any()))
                .thenReturn(Optional.empty());

        // When & Then
        PriceNotFoundException exception = assertThrows(
                PriceNotFoundException.class,
                () -> getPriceService.getPrice(query));

        assertEquals("Precio no encontrado para los parametros indicados", exception.getMessage());
    }
}
