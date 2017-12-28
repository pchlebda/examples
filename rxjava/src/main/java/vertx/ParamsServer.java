package vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class ParamsServer {

    public void start() {
        Vertx vertx = Vertx.factory.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route route = router.route(HttpMethod.POST, "/catalogue/products/:producttype/:productid")
                .handler(routingContext -> {
                    String producttype = routingContext.request()
                            .getParam("producttype");
                    String productid = routingContext.request()
                            .getParam("productid");

                    String body = String.format("producttype:%s productid:%s", producttype, productid);

                    routingContext.response()
                            .end(body);
                });

        server.requestHandler(router::accept)
                .listen(8080);
    }
}
