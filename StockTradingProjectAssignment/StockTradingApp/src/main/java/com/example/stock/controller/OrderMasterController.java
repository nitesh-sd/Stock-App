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

import com.example.stock.ModelClass.OrderMaster;
import com.example.stock.service.OrderMasterService;

// OrderMasterController.java
	@RestController
	@RequestMapping("/api/orders")
	public class OrderMasterController {
	    @Autowired
	    private OrderMasterService orderMasterService;

	    @GetMapping
	    public List<OrderMaster> getAllOrders() {
	        return orderMasterService.getAllOrders();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<OrderMaster> getOrderById(@PathVariable(value = "id") Long orderId) {
	        OrderMaster orderMaster = orderMasterService.getOrderById(orderId);
	        return ResponseEntity.ok().body(orderMaster);
	    }

	    @PostMapping
	    public OrderMaster createOrder(@RequestBody OrderMaster orderMaster) {
	        return orderMasterService.createOrder(orderMaster);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<OrderMaster> updateOrder(@PathVariable(value = "id") Long orderId,
	                                                   @RequestBody OrderMaster orderMasterDetails) {
	        OrderMaster updatedOrder = orderMasterService.updateOrder(orderId, orderMasterDetails);
	        return ResponseEntity.ok(updatedOrder);
	    }

	    @DeleteMapping("/{id}")
	    public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) {
	        orderMasterService.deleteOrder(orderId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}

