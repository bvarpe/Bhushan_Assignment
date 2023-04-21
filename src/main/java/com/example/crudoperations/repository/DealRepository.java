package com.example.crudoperations.repository;


import com.example.crudoperations.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal,String > {
    Deal findDealByDealNumber(String dealNumber);
}
