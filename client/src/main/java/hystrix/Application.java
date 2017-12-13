package hystrix;



public class Application {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            String result = new GreetingCommand().execute();
            System.out.println(result);
            Thread.sleep(3000);
        }
    }
}
