package com.example.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.ModelClass.OrderMaster;
import com.example.stock.repository.OrderMasterRepository;

@Service
public class OrderMasterService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    public List<OrderMaster> getAllOrders() {
        return orderMasterRepository.findAll();
    }

    public OrderMaster getOrderById(Long orderId) {
        return orderMasterRepository.findById(orderId).get();
         //   .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
    }

    public OrderMaster createOrder(OrderMaster orderMaster) {
        orderMaster.setStatus("created");
        return orderMasterRepository.save(orderMaster);
    }

    public OrderMaster updateOrder(Long orderId, OrderMaster orderMasterDetails) {
        OrderMaster orderMaster = getOrderById(orderId);

        orderMaster.setTradeDetail(orderMasterDetails.getTradeDetail());
        orderMaster.setQuantity(orderMasterDetails.getQuantity());
        orderMaster.setPricePerUnit(orderMasterDetails.getPricePerUnit());
        orderMaster.setStatus(orderMasterDetails.getStatus());

        return orderMasterRepository.save(orderMaster);
    }

    public void deleteOrder(Long orderId) {
        OrderMaster orderMaster = getOrderById(orderId);
        orderMasterRepository.delete(orderMaster);
    }
}
