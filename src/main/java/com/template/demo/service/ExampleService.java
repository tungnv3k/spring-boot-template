package com.template.demo.service;

import com.template.demo.dto.request.ExampleRequest;
import com.template.demo.dto.response.ExampleResponse;
import com.template.demo.enums.ExampleEnum;
import com.template.demo.exception.ExampleException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public ExampleResponse getExample(ExampleRequest request) {
        String example = request.example();
        if (StringUtils.equals(request.example(), "example")) {
            example = ExampleEnum.EXAMPLE.name();
        }
        if (StringUtils.equals(request.example(), "not_example")) {
            example = ExampleEnum.NOT_EXAMPLE.name();
        }
        return new ExampleResponse(example);
    }

    public ExampleResponse getExampleException(ExampleRequest request) {
        throw new ExampleException(request.example());
    }
}
