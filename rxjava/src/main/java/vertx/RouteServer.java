package vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteServer {

    public void route() {
        Vertx vertx = Vertx.factory.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route firstRoute = router.route("/some/path")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();

                    response.setChunked(true);
                    response.write("first route\n");

                    routingContext.vertx()
                            .setTimer(5000, tid -> routingContext.next());
                });

        Route secondRoute = router.route("/some/path")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();

                    response.write("second route\n");

                    routingContext.vertx()
                            .setTimer(5000, tid -> routingContext.next());
                });

        Route thirdRoute = router.route("/some/path")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();

                    response.write("third route");

                    routingContext.response()
                            .end();
                });

        server.requestHandler(router::accept).listen(8080);
    }
}
