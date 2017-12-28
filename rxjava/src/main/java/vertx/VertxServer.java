package vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class VertxServer {

    public void start() throws Exception {
        Vertx vertx = Vertx.factory.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route route = router.route().path("/some/path/");

        route.handler(request -> {
            HttpServerResponse response = request.response();
            response.putHeader("Content-Type", "text/plain");

            response.end("Some path");
        });

        server.requestHandler(router::accept).listen(3030);



       /* server.requestHandler(request -> {
            HttpServerResponse response = request.response();
            response.putHeader("Content-Type", "text/plain");

            response.end("Hello World!");
        });

        server.listen(3030);*/
    }
}
