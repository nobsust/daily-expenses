package com.github.nobsust.dex.core;

import com.github.nobsust.dex.api.ExpenseDto;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sam on 2/1/2017.
 */
public class Server extends AbstractVerticle {

    private final int HTTP_PORT = Integer.valueOf(System.getenv("PORT"));
    private final String JSON_CONTENT_TYPE = "application/json; charset=utf-8";

    private Map<Integer, ExpenseDto> expenses = new LinkedHashMap<>();

    @Override
    public void start(Future<Void> future) throws Exception {

        Router router = Router.router(vertx);

        router.route("/site").handler(StaticHandler.create("public"));

        router.get("/api/info").handler(this::getInfo);

        router.route("/api/expenses*").handler(BodyHandler.create());

        router.get("/api/expenses").handler(this::getAll);

        router.post("/api/expenses").handler(this::addOne);

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

    private void getInfo(RoutingContext routingContext) {
        routingContext.response()
                .putHeader("content-type", JSON_CONTENT_TYPE)
                .end("{ \"version\": \"1.0.1\"}");
    }

    private void getAll(RoutingContext routingContext) {
        routingContext.response()
                .putHeader("content-type", JSON_CONTENT_TYPE)
                .end(Json.encodePrettily(expenses.values()));
    }

    private void addOne(RoutingContext routingContext) {
        final ExpenseDto expense = Json.decodeValue(routingContext.getBodyAsString(), ExpenseDto.class);
        expenses.put(expense.getId(), expense);
        routingContext.response()
                .setStatusCode(201)
                .putHeader("content-type", JSON_CONTENT_TYPE)
                .end(Json.encodePrettily(expense));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
