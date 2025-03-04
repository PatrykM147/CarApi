package com.example.carapi.model.command;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCarCommand {
    @NotEmpty(message = "BRAND_NOT_EMPTY")
    private String brand;
    @NotEmpty(message = "MODEL_NOT_EMPTY")
    private String model;
    @NotEmpty(message = "REGISTRATION_NUMBER_NOT_EMPTY")
    @Pattern(regexp = "^[A-Z]{1,3}\\s?[0-9]{1,5}[A-Z]?$", message = "INVALID_REGISTRATION_NUMBER")
    private String registrationNumber;
    @NotNull(message = "PRODUCTION_DATE_NOT_NULL")
    @PastOrPresent(message = "PRODUCTION_DATE_MUST_BE_IN_THE_PAST")
    private Date productionDate;
    @NotNull(message = "PRICE_NOT_NULL")
    @DecimalMin(value = "0", message = "INVALID_MIN_PRICE")
    private BigDecimal price;
}
