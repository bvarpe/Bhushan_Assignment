package com.example.crudoperations.service.deal;

import com.example.crudoperations.dto.DealDto;

public interface DealService {
    DealDto createDeal(DealDto dealDto) ;
    DealDto getDealById(String dealNumber);
    boolean deleteDealById(String dealNumber);
    DealDto updateDealById(String dealNumber ,DealDto dealDto);
}
