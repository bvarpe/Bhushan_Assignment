package com.example.crudoperations.service.deal;

import com.example.crudoperations.dto.DealDto;
import com.example.crudoperations.entity.Deal;
import com.example.crudoperations.exceptions.DealException;
import com.example.crudoperations.exceptions.DealNotCreatedException;
import com.example.crudoperations.exceptions.DealNotUpdated;
import com.example.crudoperations.repository.DealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
@Service
public class DealDomainService implements DealService{
    private final Logger log = LoggerFactory.getLogger(this.getClass());
        @Autowired
    private DealJpaService dealJpaService;
    @Autowired
    private DealRepository dealRepostory;

    @Override
    public DealDto createDeal(DealDto dealDto){
        String randomDealNumber = UUID.randomUUID().toString();
        dealDto.setDealNumber(randomDealNumber);
        dealDto.setSoldTime(LocalDateTime.now().toInstant(ZoneOffset.ofHours(0)));

        Deal deal = dealJpaService.convertDealDtoTODeal(dealDto);
        try{
            dealRepostory.save(deal);
        }catch (Exception exception){
            log.info("Deal Not Created");
            throw new DealNotCreatedException("Deal not Created");
        }
        return dealDto;
    }
@Override
    public DealDto getDealById(String dealNumber) {
        Deal deal = dealRepostory.findDealByDealNumber(dealNumber);
        if(deal == null){
            log.info("Deal not exists with id  :" + dealNumber);
            throw new DealException("Deal not found  with id  :", dealNumber);
        }
        DealDto dealDtomain=dealJpaService.convertDealToDto(deal);
            return dealDtomain;

    }

@Override
    public boolean deleteDealById(String dealNumber){
    Deal deal=dealRepostory.findDealByDealNumber(dealNumber);
    if ((deal== null)) {
        log.info("Deal not exists with id  :" + dealNumber);
        throw new DealException("Deal not found  with id :", dealNumber);
    }
        dealRepostory.deleteById(dealNumber);
      return true;
    }


@Override
    public DealDto updateDealById(String dealNumber,DealDto dealDto){
    Deal deal = dealRepostory.findDealByDealNumber(dealNumber);
    if(deal == null){
        log.info("Deal not exists with id  :" + dealNumber);
        throw new DealException("Deal not found  with id  :", dealNumber);
    }
    try {
        Deal deal1 = dealJpaService.convertDealDtoTODeal(dealDto);
        deal.setSalesRep(deal1.getSalesRep());
        dealRepostory.save(deal);
    }catch (Exception e){
        throw new DealNotUpdated("Deal Not updated with ID : ", dealNumber);
    }
    DealDto dealDtomain=dealJpaService.convertDealToDto(deal);
    return dealDtomain;
    }

    @Override
    public DealDto updateDealByIdUsingPut(String dealNumber,DealDto dealDto) {
        Deal existingDeal = dealRepostory.findDealByDealNumber(dealNumber);
        if (existingDeal == null) {
            log.info("Deal not exists with id  :" + dealNumber);
            throw new DealException("Deal not found  with id  :", dealNumber);
        }
        try {
            Deal deal1 = dealJpaService.convertDealDtoTODeal(dealDto);
            dealJpaService.copyAllProperties(deal1 ,existingDeal);
            existingDeal.setDealNumber(dealNumber);
            dealRepostory.saveAndFlush(existingDeal);
        } catch (Exception e) {
            throw new DealNotUpdated("Deal Not updated with ID : ", dealNumber);
        }
        DealDto dealDtomain = dealJpaService.convertDealToDto(existingDeal);
        return dealDtomain;
    }
}
