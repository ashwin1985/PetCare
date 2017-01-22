package com.petcare.server.app;

import com.google.inject.AbstractModule;
import com.petcare.server.handler.*;
import com.petcare.server.service.HelloService;
import com.petcare.server.validation.ValidationWrapper;

import javax.validation.Validation;
import javax.validation.Validator;

public class BindModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Validator.class).toInstance(Validation.buildDefaultValidatorFactory().getValidator());
        bind(ValidationWrapper.class);
        bind(HelloService.class);
        bind(HelloHandler.class);
    }
}
