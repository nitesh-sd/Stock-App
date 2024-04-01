package com.example.stock.ModelClass;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TradeDetail {
	// TradeDetail.java

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime tradeDateTime;
	private String stockName;
	private Double listingPrice;
	private Integer quantity;
	private String type; // buy or sell
	private Double pricePerUnit;

	// Getters and setters
}
