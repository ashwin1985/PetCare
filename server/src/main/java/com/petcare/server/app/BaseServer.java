package com.petcare.server.app;

import com.petcare.server.handler.HelloHandler;
import ratpack.guice.Guice;
import ratpack.server.RatpackServer;

class BaseServer {

    void start() throws Exception {
        try {
            RatpackServer.start(
                    server -> server.registry(Guice.registry(a -> a.module(BindModule.class)))
                            .serverConfig(serverConfig -> {
                                serverConfig.port(5050);
                            })
                            .handlers(chain -> chain
                                    .post("hello", HelloHandler.class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}