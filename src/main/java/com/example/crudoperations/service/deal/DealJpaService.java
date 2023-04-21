package com.example.crudoperations.service.deal;

import com.example.crudoperations.dto.DealDto;
import com.example.crudoperations.entity.Deal;
import com.example.crudoperations.entity.SalesRep;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class DealJpaService {
    @Autowired
    private ModelMapper modelMapper;

    public Deal convertDealDtoTODeal(DealDto dealDto){
         Deal deal=modelMapper.map(dealDto,Deal.class);
        return  deal;
    }

    public SalesRep setSalesRepId(SalesRep salesRep){

        String randomId = UUID.randomUUID().toString();
        String randomGlobalId = UUID.randomUUID().toString();
        salesRep.setId(randomId);
        salesRep.setGlobalId(randomGlobalId);
        return salesRep;
    }

    public DealDto convertDealToDto(Deal deal){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DealDto dealDtomain =modelMapper.map(deal,DealDto.class);
        return dealDtomain;
    }

     public SalesRep  getSalesRep(Deal existingDeal){
       SalesRep salesRep= existingDeal.getSalesRep();
         return salesRep;
     }


}
