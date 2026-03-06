package com.tutorial.car_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.car_service.entity.Car;

@Repository
public interface I_CarRepository extends JpaRepository<Car, Integer> {
    
    List<Car> findByUserId(int userId);

    
}
