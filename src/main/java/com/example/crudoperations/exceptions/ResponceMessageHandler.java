package com.example.crudoperations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class ResponceMessageHandler {
    public Map<String ,Object> dealNotCteated(){
        Map<String ,Object> mapDealNotCreated=new HashMap<String,Object>();
        mapDealNotCreated.put("message","Deal not Created");
        mapDealNotCreated.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);
        return mapDealNotCreated;
    }

    public Map<String ,Object> dealNotDeleted(){
        Map<String ,Object> mapDealNotDeleted=new HashMap<String,Object>();
        mapDealNotDeleted.put("message","Deal not Deleted");
        mapDealNotDeleted.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);
        return mapDealNotDeleted;
    }
    public Map<String ,Object> dealCreated(){
        Map<String ,Object> mapDealCreated=new HashMap<String,Object>();
        mapDealCreated.put("message","Deal Created");
        mapDealCreated.put("Status", HttpStatus.CREATED);
        return mapDealCreated;
    }

    public Map<String ,Object> dealDeleted(){
        Map<String ,Object> mapDealDeleted=new HashMap<String,Object>();
        mapDealDeleted.put("message","Deal Deleted");
        mapDealDeleted.put("Status", HttpStatus.OK);
        return mapDealDeleted;
    }
    public Map<String ,Object> dealNotUpdated(){
        Map<String ,Object> mapdealNotUpdated=new HashMap<String,Object>();
        mapdealNotUpdated.put("message","Deal Not Updated");
        mapdealNotUpdated.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);
        return mapdealNotUpdated;
    }



}
