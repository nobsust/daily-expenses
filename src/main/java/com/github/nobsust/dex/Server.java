package com.github.nobsust.dex;

import io.vertx.core.AbstractVerticle;

/**
 * Created by Sam on 2/1/2017.
 */
public class Server extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("content-type", "text/html").end("<html><body><h1>Hello from vert.x!</h1></body></html>");
        }).listen(8080);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
