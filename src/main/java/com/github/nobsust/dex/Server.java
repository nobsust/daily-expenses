package com.github.nobsust.dex;

import io.vertx.core.AbstractVerticle;

/**
 * Created by Sam on 2/1/2017.
 */
public class Server extends AbstractVerticle {

    private final int PORT = Integer.valueOf(System.getenv("PORT"));

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        }).listen(PORT);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
