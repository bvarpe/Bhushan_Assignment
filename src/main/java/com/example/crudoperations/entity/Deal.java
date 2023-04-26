package com.example.crudoperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Embedded;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name ="bhushan_deal")
public class Deal {

    @NotNull(message = "TEKION_DEAL_NUMBER_CANNOT_BE_NULL")
    @Id
    private String dealNumber;
   @Column(name="sale_status")
    private String saleStatus;
    @Column(name="saleType")
   private String saleType;
    @Column(name="soldTime")
    private Instant soldTime;
    @NotNull(message = "DEAL_SOURCE_CANNOT_BE_NULL")
    private String source;
    @NotNull(message = "DEAL_SOURCE_TAG_CANNOT_BE_NULL")
    private String sourceTag;
    @NotNull(message = "DEALERSHIP_CANNOT_BE_NULL")
    private String dealershipId;
    private String createdBy;
    private String updatedBy;
    private Date dateCreated;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "stockNumber", column = @Column(name = "vehicleStockNumber")),
            @AttributeOverride(name = "vin", column = @Column(name = "vehicleVin")),
            @AttributeOverride(name = "year", column = @Column(name = "vehicleYear")),
            @AttributeOverride(name = "make", column = @Column(name = "vehicleMake")),
            @AttributeOverride(name = "model", column = @Column(name = "vehicleModel")),
            @AttributeOverride(name = "trim", column = @Column(name = "vehicleTrim")),
            @AttributeOverride(name = "type", column = @Column(name = "vehicletype")),
            @AttributeOverride(name = "color", column = @Column(name = "vehicleColor"))

    })
    private Vehicle vehicle;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "lastName", column = @Column(name = "lastName")),
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "homePhone", column = @Column(name = "homePhone")),
            @AttributeOverride(name = "workPhone", column = @Column(name = "workPhone")),
            @AttributeOverride(name = "cellPhone", column = @Column(name = "cellPhone")),
            @AttributeOverride(name = "primaryPhone", column = @Column(name = "primaryPhone")),
            @AttributeOverride(name = "addressLineOne", column = @Column(name = "address_line1")),
            @AttributeOverride(name = "addressLineTwo", column = @Column(name = "address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "state", column = @Column(name = "state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zipCode")),
            @AttributeOverride(name = "county", column = @Column(name = "county")),
            @AttributeOverride(name = "country", column = @Column(name = "country"))
    })
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER , cascade= {CascadeType.MERGE})
    @JoinColumn(name ="sales_rep_id")
    private SalesRep salesRep;

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
