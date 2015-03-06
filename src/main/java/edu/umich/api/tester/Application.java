package edu.umich.api.tester;

import edu.umich.api.tester.domain.APIResponses;
import edu.umich.api.tester.service.APITesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class Application implements CommandLineRunner {

    @Autowired
    private APITesterService service;
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }

    /**
     * will run once every 1000000000 ms until we figure out what to do with the
     * cached results
     */
    @Scheduled(fixedDelay = 1000000000)
    public void onScheduleInvokeAllAPIRequests() {
        logger.info("starting run");
        APIResponses apis = service.invokeAllAPIRequests();
        service.report(apis);
        logger.info("ended run");
    }
}
