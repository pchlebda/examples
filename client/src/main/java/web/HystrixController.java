package web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    @Autowired
    public HystrixController(RestTemplate restTemplate, @Value("${server.hello.url}") String serverUrl) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }


    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/call")
    public String callServer() {
        return restTemplate.getForObject(serverUrl, String.class);
    }


    private String fallback(){
        return "This is fallback";
    }
}
