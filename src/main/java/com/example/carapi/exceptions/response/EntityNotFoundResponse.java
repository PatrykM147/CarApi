package com.example.carapi.exceptions.response;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EntityNotFoundResponse {

    private final int id;
    private final String name;

    public String getMessage() {
        return name + " with id " + id + " not found";
    }
}
