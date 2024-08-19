package com.template.demo.dto.response;

public record ExampleResponse(String example) {

    @Override
    public String toString() {
        return example;
    }
}
