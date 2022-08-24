package com.example.gmrestapi.repository;

import com.example.gmrestapi.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
