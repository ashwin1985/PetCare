package com.petcare.server.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.petcare.server.dto.HelloRequest;
import com.petcare.server.service.HelloService;
import com.petcare.server.validation.ValidationWrapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

@Singleton
public class HelloHandler implements Handler {

    private ValidationWrapper validationWrapper;
    private HelloService helloService;

    @Inject
    public HelloHandler(HelloService helloService, ValidationWrapper validationWrapper) {
        this.helloService = helloService;
        this.validationWrapper = validationWrapper;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.byMethod(methodSpec
                -> methodSpec.post(() -> ctx.parse(Jackson.fromJson(HelloRequest.class))
                .then(helloRequest -> handleHelloRequest(ctx, helloRequest))));
    }

    public void handleHelloRequest(Context ctx, HelloRequest helloRequest) {

        if(!validationWrapper.validate(helloRequest)) {
            ctx.getResponse().status(HttpResponseStatus.BAD_REQUEST.code()).send();
            return;
        }

        Promise.async(downstream ->
                downstream.success(helloService.getHelloString(helloRequest)))
                .then(result -> ctx.render(json(result)));
    }
}
