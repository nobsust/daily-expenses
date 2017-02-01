package com.github.nobsust.dex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by Sam on 2/1/2017.
 */
public class Server extends AbstractVerticle {

    private final int HTTP_PORT = Integer.valueOf(System.getenv("PORT"));

    @Override
    public void start(Future<Void> future) throws Exception {

        Router router = Router.router(vertx);

        router.route("/*").handler(StaticHandler.create("public"));

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(HTTP_PORT, result -> {
                    if (result.succeeded()) {
                        future.complete();
                    } else {
                        future.fail(result.cause());
                    }
                });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
