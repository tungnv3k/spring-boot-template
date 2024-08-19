package com.template.demo.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ExampleRequest(@NotBlank String example) {

    @Override
    public String toString() {
        return example;
    }
}
