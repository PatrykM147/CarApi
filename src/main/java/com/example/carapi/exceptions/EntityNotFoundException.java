package com.example.carapi.exceptions;

import lombok.Value;

@Value
public class EntityNotFoundException extends RuntimeException {
    String name;
    int id;
}
