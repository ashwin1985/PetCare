package com.petcare.server.service;

import com.petcare.server.dto.HelloRequest;
import com.petcare.server.dto.HelloResult;

public class HelloService {

    public HelloResult getHelloString(HelloRequest helloRequest) {
        return new HelloResult("hello " + helloRequest.getName());
    }

}
