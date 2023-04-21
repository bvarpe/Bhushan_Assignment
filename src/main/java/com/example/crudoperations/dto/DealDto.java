package com.example.crudoperations.dto;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Date;

@Component
public class DealDto  {
    private String dealNumber;
    private String saleStatus;
    private String saleType;
    private Instant soldTime;
    private String source;
    private String sourceTag;
    private String dealershipId;
    private String createdBy;
    private String updatedBy;
    private Date dateCreated;

    private VehicleDto vehicleDto;

    private CustomerDto customerDto;

    private SalesRepDto salesRepDto;


    public SalesRepDto getSalesRepDto() {
        return salesRepDto;
    }

    public void setSalesRepDto() {
        this.salesRepDto = salesRepDto;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public String getDealNumber() {
        return dealNumber;
    }

    public void setDealNumber(String dealNumber) {
        this.dealNumber = dealNumber;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Instant getSoldTime() {
        return soldTime;
    }

    public VehicleDto getVehicleDto() {
        return vehicleDto;
    }

    public void setVehicleDto(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
    }

    public void setSoldTime(Instant soldTime) {
        this.soldTime = soldTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceTag() {
        return sourceTag;
    }

    public void setSourceTag(String sourceTag) {
        this.sourceTag = sourceTag;
    }

    public String getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(String dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}