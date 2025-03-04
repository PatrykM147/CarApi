package com.example.carapi.model.dto;

import com.example.carapi.model.domain.Car;

public record CarDto(long id, String brand, String model, String registrationNumber) {

    public static CarDto of(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getRegistrationNumber()
        );
    }
}
