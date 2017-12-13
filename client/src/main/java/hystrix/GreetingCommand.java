package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GreetingCommand extends HystrixCommand<String> {

    private static final String URL = "http://localhost:8080/";
    private RestTemplate restTemplate;

    protected GreetingCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("GreetingCommand"));
        restTemplate = new RestTemplate();
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject(URL,String.class);
    }

    @Override
    protected String getFallback() {
        return "fallback";
    }
}
