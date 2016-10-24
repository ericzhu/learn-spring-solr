package com.booster.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booster.data.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    public Stock findBySymbol(String symbol);

}
