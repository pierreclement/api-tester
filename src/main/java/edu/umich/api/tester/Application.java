package edu.umich.api.tester;

import edu.umich.api.tester.domain.APIs;
import edu.umich.api.tester.service.APITesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private APITesterService service;
    private Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");
    

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("starting first run");
        APIs apis = service.invokeAll();
        if (apis == null || apis.getApis().isEmpty()) {
            logger.warn("invoked 0 apis");
        } else {
            logger.info("invoked " + apis.getApis().size() + " apis");
        }
    }
}
