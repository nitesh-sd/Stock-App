package com.example.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.ModelClass.TradeDetail;
import com.example.stock.service.TradeDetailService;

// TradeDetailController.java
	@RestController
	@RequestMapping("/api/trades")
	public class TradeDetailController {
	    @Autowired
	    private TradeDetailService tradeDetailService;

	    @GetMapping
	    public List<TradeDetail> getAllTradeDetails() {
	        return tradeDetailService.getAllTradeDetails();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TradeDetail> getTradeDetailById(@PathVariable(value = "id") Long tradeId) {
	        TradeDetail tradeDetail = tradeDetailService.getTradeDetailById(tradeId);
	        return ResponseEntity.ok().body(tradeDetail);
	    }

	    @PostMapping
	    public TradeDetail createTradeDetail(@RequestBody TradeDetail tradeDetail) {
	        return tradeDetailService.createTradeDetail(tradeDetail);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TradeDetail> updateTradeDetail(@PathVariable(value = "id") Long tradeId,
	                                                         @RequestBody TradeDetail tradeDetailDetails) {
	        TradeDetail updatedTradeDetail = tradeDetailService.updateTradeDetail(tradeId, tradeDetailDetails);
	        return ResponseEntity.ok(updatedTradeDetail);
	    }

	    @DeleteMapping("/{id}")
	    public Map<String, Boolean> deleteTradeDetail(@PathVariable(value = "id") Long tradeId) {
	        tradeDetailService.deleteTradeDetail(tradeId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}
	
	


