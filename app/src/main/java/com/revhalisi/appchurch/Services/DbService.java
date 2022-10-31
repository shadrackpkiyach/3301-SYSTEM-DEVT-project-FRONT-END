package com.revhalisi.appchurch.Services;
/**
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class DbService extends AbstractV {

    /**
     * Users
     *      -Add user(s) to database
     *      -Fetch a user from the database
     *      -Fetch a list of users from the database
     */

 /*   private MongoClient dbClient;

    private static final String USERS_TABLE = "user";

    @Override
    public void start() {

        JsonObject config = new JsonObject()
                .put("db_name", "Promtech")
                .put("connectionn-string", "Mongo://localhost:27017");


        this.dbClient = MongoClient.create(this.vertx, config());

        Router r = Router.router(this.vertx);
        r.get("/").handler(this::ping);
        r.post("/createuser").handler(this::createUser);
        r.post("/getuser").handler(this::getUser);
        r.get("/listusers").handler(this::listUsers);

        this.vertx.createHttpServer()
                .requestHandler(r)
                .listen(8080);

    }

    private void listUsers(final RoutingContext rc){
        JsonObject qry = new JsonObject();
        this.dbClient.find(USERS_TABLE, qry, res ->{
            if (res.succeeded()){
                JsonArray rst = new JsonArray(res.result());
                rc.response().end(rst.encode());


            }else{
                JsonObject err = new JsonObject()
                        .put("error", rc.response().end(res.cause().getMessage()));

                rc.response().end(err.encode());
            }

        });

    }

    private void getUser(final RoutingContext rc) {
        rc.request().bodyHandler(b ->{
            JsonObject body = b.toJsonObject();
            dbClient.findOne(USERS_TABLE, body,
                    new JsonObject(), res -> {
                        if (res.succeeded()){
                            rc.response().end(res.result().encode());
                        }else {

                            JsonObject err = new JsonObject()
                                    .put("body", body)
                                    .put("error", rc.response().end(res.cause().getMessage()));

                            rc.response().end(err.encode());

                        }
                    });

        });
    }

    private void ping(final RoutingContext rc){
        rc.response().end("Welcome to PromTech");
    }

    private void createUser(final RoutingContext rc){
        rc.request().bodyHandler(b ->{
            JsonObject body = b.toJsonObject();
            dbClient.insert(USERS_TABLE, body, res ->{
                if(res.succeeded()){
                    rc.response().end(body.encode());
                }else{
                    JsonObject err = new JsonObject()
                            .put("body", body)
                            .put("error", rc.response().end(res.cause().getMessage()));

                    rc.response().end(err.encode());


                }

            });


        });


    }

}

*/