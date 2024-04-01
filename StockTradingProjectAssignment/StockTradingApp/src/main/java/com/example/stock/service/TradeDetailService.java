package com.example.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.ModelClass.TradeDetail;
import com.example.stock.repository.TradeDetailRepository;

@Service
public class TradeDetailService {
    @Autowired
    private TradeDetailRepository tradeDetailRepository;

    public List<TradeDetail> getAllTradeDetails() {
        return tradeDetailRepository.findAll();
    }

    public TradeDetail getTradeDetailById(Long tradeId) {
        return tradeDetailRepository.findById(tradeId).get();
               // .orElseThrow(() -> new ResourceNotFoundException("Trade not found with id: " + tradeId));
    }

    public TradeDetail createTradeDetail(TradeDetail tradeDetail) {
        return tradeDetailRepository.save(tradeDetail);
    }

    public TradeDetail updateTradeDetail(Long tradeId, TradeDetail tradeDetailDetails) {
        TradeDetail tradeDetail = getTradeDetailById(tradeId);

        tradeDetail.setTradeDateTime(tradeDetailDetails.getTradeDateTime());
        tradeDetail.setStockName(tradeDetailDetails.getStockName());
        tradeDetail.setListingPrice(tradeDetailDetails.getListingPrice());
        tradeDetail.setQuantity(tradeDetailDetails.getQuantity());
        tradeDetail.setType(tradeDetailDetails.getType());
        tradeDetail.setPricePerUnit(tradeDetailDetails.getPricePerUnit());

        return tradeDetailRepository.save(tradeDetail);
    }

    public void deleteTradeDetail(Long tradeId) {
        TradeDetail tradeDetail = getTradeDetailById(tradeId);
        tradeDetailRepository.delete(tradeDetail);
    }
}
