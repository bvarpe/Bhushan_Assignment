package com.example.crudoperations.resource.deal;

import com.example.crudoperations.dto.DealDto;
import com.example.crudoperations.exceptions.ResponceMessageHandler;
import com.example.crudoperations.service.deal.DealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.Map;

@RestController
public class DealController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealController.class);
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  DealService dealService;
    @Autowired
    private ResponceMessageHandler responceHandler;

    @PostMapping("/deal/create")
    public ResponseEntity<Map<String,Object>> creatDeal(@RequestBody DealDto dealDto) {
        try {
            dealService.createDeal(dealDto);
            log.info("Deal Created with Id :"+dealDto.getDealNumber());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(responceHandler.dealCreated());
        }catch (Exception exception){
            log.info("Deal not Created ");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(responceHandler.dealNotCteated());
        }
    }
    @GetMapping("/deal/getById/{dealNumber}")
    public ResponseEntity<DealDto> getDealById(@PathVariable String dealNumber){
        DealDto dealDto=dealService.getDealById(dealNumber);
            return ResponseEntity.status(HttpStatus.OK).body(dealDto);
    }

    @DeleteMapping("/deal/deleteById/{dealNumber}")
    public ResponseEntity<Map<String,Object>> deleteDealById(@PathVariable String dealNumber){
        if (dealService.deleteDealById(dealNumber)) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(responceHandler.dealDeleted());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(responceHandler.dealNotDeleted());
        }
    }
  @PatchMapping("/deal/updateById/{dealNumber}")
    public ResponseEntity<DealDto> updateDealById(@PathVariable String dealNumber,@RequestBody DealDto dealDto) {
               DealDto deal=dealService.updateDealById(dealNumber, dealDto);
               return ResponseEntity.status(HttpStatus.OK).body(deal);
  }
}
