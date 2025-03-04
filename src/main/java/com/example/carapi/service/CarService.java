package com.example.carapi.service;

import com.example.carapi.exceptions.EntityNotFoundException;
import com.example.carapi.model.command.CreateCarCommand;
import com.example.carapi.model.domain.Car;
import com.example.carapi.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    @Transactional(readOnly = true)
    public Page<Car> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Car findById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car", id));
    }

    @Transactional
    public Car saveCar(CreateCarCommand command) {
        return carRepository.saveAndFlush(new Car(command.getBrand(), command.getModel(), command.getRegistrationNumber(), command.getProductionDate(), command.getPrice()));
    }

    @Transactional
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
