package com.example.carapi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "update car set removed = true where id = ? and version = ?")
@Where(clause = "removed = false")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private Date productionDate;
    private BigDecimal price;
    private boolean removed = false;
    @Version
    private int version;

    public Car(String brand, String model, String registrationNumber, Date productionDate, BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.productionDate = productionDate;
        this.price = price;
    }
}
