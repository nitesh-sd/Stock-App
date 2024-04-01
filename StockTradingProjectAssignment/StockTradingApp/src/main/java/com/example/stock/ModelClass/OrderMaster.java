package com.example.stock.ModelClass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

// OrderMaster.java
@Entity
@Data
public class OrderMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private TradeDetail tradeDetail;

	private Integer quantity;
	private Double pricePerUnit;
	private String status; // created, confirmed, etc.
	
	
	/*. On creation of order the data will be persisted in order table with the 
trade info (quantity, per unit price, type, stock etc) and with status as 
"created" ,*/

	// Getters and setters
}
