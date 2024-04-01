package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.ModelClass.TradeDetail;

public interface TradeDetailRepository extends JpaRepository<TradeDetail, Long> {

}
