package com.example.rmj_ecomerce.infra.persistence.repo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rmj_ecomerce.infra.persistence.entity.PriceEntity;

public interface JpaPriceRepo extends JpaRepository<PriceEntity, Integer> {
    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findTopByProductIdAndBrandIdAndDateOrderByPriorityDesc(
            int productId,
            int brandId,
            LocalDateTime applicationDate);
}
