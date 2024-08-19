package com.template.demo.controller;

import com.template.demo.dto.request.ExampleRequest;
import com.template.demo.dto.response.ExampleResponse;
import com.template.demo.service.ExampleService;
import com.template.demo.util.ExampleUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping
    public ResponseEntity<String> greet(@RequestParam(value = "lowercase", required = false) Boolean lowercase) {
        String greeting = "Hello Example!";
        if (Boolean.TRUE.equals(lowercase)) {
            greeting = ExampleUtil.lowercase(greeting);
        }
        return ResponseEntity.ok(greeting);
    }

    @GetMapping("/get")
    public ResponseEntity<ExampleResponse> getExample(ExampleRequest request) {
        return ResponseEntity.ok(exampleService.getExample(request));
    }

    @GetMapping("/get-exception")
    public ResponseEntity<ExampleResponse> getExampleException(ExampleRequest request) {
        return ResponseEntity.ok(exampleService.getExampleException(request));
    }

    @GetMapping("/get-valid")
    public ResponseEntity<ExampleResponse> getExampleValid(@Valid ExampleRequest request) {
        return ResponseEntity.ok(exampleService.getExample(request));
    }
}
