package com.koweg.poc.audit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.core.env.Environment;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class AuditVerticle extends AbstractVerticle {

    private static final String HTTP_PORT = "koweg.audit.verticle.http.port";
    private final Environment env;

    public AuditVerticle(Environment environment) {
        this.env = environment;
    }

    @Override
    public void start() throws Exception {
 
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());

        router.get("/audits").handler(this::handleGetAudits);

        vertx.createHttpServer().requestHandler(router).listen(Integer.valueOf(env.getProperty(HTTP_PORT)));

    }

    private void handleGetAudits(RoutingContext context) {
        context.response()
            .setStatusCode(200)
            .putHeader("Contet-Type", "application/json")
            .end(_loadAudits().encodePrettily());
    }

    private JsonArray _loadAudits() {
        AtomicInteger idGenerator = new AtomicInteger(1000);
        JsonArray result = new JsonArray();
        result.add(new JsonObject().put("id", idGenerator.getAndIncrement()).put("date", LocalDate.now().minusDays(RandomUtils.nextLong(300L, 700L)).toString()).put("journal", "PAYMENT_RECEIVED").put("content", "TODO"));
        result.add(new JsonObject().put("id", idGenerator.getAndIncrement()).put("date", LocalDate.now().minusDays(RandomUtils.nextLong(300L, 700L)).toString()).put("journal", "PAYMENT_INITIATED").put("content", "TODO"));
        result.add(new JsonObject().put("id", idGenerator.getAndIncrement()).put("date", LocalDate.now().minusDays(RandomUtils.nextLong(300L, 700L)).toString()).put("journal", "PAYMENT_SUCCESS").put("content", "TODO"));
         return result;
    }

    private JsonObject loadAudits() {
            AtomicInteger idGenerator = new AtomicInteger(1000);
            JsonObject object = new JsonObject();
            object.put("id", idGenerator.getAndIncrement());
            object.put("date", LocalDate.now().minusDays(RandomUtils.nextLong(0, 100L)).toString());
            object.put("journal", "PAYMENT_RECEIVED");
            object.put("content", idGenerator.getAndIncrement());
            return object;
    }

}
