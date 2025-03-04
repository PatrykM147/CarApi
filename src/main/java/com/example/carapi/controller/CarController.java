package com.example.carapi.controller;

import com.example.carapi.model.command.CreateCarCommand;
import com.example.carapi.model.domain.Car;
import com.example.carapi.model.dto.CarDto;
import com.example.carapi.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@Slf4j
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars(@PageableDefault Pageable pageable) {
        log.info("getAllAuthors()");
        return ResponseEntity.ok(carService.getAllCars(pageable).map(CarDto::of).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable int id) {
        log.info("getCarById({})", id);
        return ResponseEntity.ok(CarDto.of(carService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CarDto> saveCar(@RequestBody @Valid CreateCarCommand command) {
        log.info("saveCar({})", command);
        Car car = carService.saveCar(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(CarDto.of(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable int id) {
        log.info("deleteCarById({})", id);
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
