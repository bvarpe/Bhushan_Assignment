package com.example.crudoperations.service.deal;

import com.example.crudoperations.dto.DealDto;
import com.example.crudoperations.entity.Deal;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DealJpaService {
    @Autowired
    private ModelMapper modelMapper;


    public Deal convertDealDtoTODeal(DealDto dealDto){
         Deal deal=modelMapper.map(dealDto,Deal.class);
        return  deal;
    }

    public DealDto convertDealToDto(Deal deal){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DealDto dealDtomain =modelMapper.map(deal,DealDto.class);
        return dealDtomain;
    }
    public Deal setAllFields(Deal deal1 ,Deal existingDeal){
        existingDeal.setSaleStatus(deal1.getSaleStatus());
        existingDeal.setDateCreated(deal1.getDateCreated());
        existingDeal.setSource(deal1.getSource());
        existingDeal.setCreatedBy(deal1.getCreatedBy());
        existingDeal.setSaleType(deal1.getSaleType());
        existingDeal.setUpdatedBy(deal1.getUpdatedBy());
        existingDeal.setDealershipId(deal1.getDealershipId());
        existingDeal.setCustomer(deal1.getCustomer());
        existingDeal.setVehicle(deal1.getVehicle());
        existingDeal.setSalesRep(deal1.getSalesRep());
        existingDeal.setSourceTag(deal1.getSourceTag());

        return existingDeal;
    }
    public  Deal copyAllProperties(Deal deal, Deal existingDeal) {
        BeanUtils.copyProperties(deal, existingDeal);
        return existingDeal;
    }
}
