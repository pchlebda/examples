package vertx;

public class Main {

    public static void main(String[] args) throws Exception {
        VertxServer vertxServer = new VertxServer();

       // vertxServer.start();

        new RouteServer().route();
    }
}
