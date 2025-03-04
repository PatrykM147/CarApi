package com.example.carapi.model.dto;

import com.example.carapi.model.domain.Car;

import java.math.BigDecimal;
import java.util.Date;

public record CarDto(long id, String brand, String model, String registrationNumber, Date productionDate, BigDecimal price) {

    public static CarDto of(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getRegistrationNumber(),
                car.getProductionDate(),
                car.getPrice()
        );
    }
}
