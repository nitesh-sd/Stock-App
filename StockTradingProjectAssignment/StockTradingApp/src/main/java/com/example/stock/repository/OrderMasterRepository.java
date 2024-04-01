package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stock.ModelClass.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long>{

}
