package com.example.rmj_ecomerce.infra.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceCtrlIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void test1() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("appDate", "2020-06-14T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("appDate", "2020-06-14T16:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("appDate", "2020-06-14T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("appDate", "2020-06-15T10:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                .param("appDate", "2020-06-16T21:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
