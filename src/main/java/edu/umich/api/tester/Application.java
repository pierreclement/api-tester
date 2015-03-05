package edu.umich.api.tester;

import edu.umich.api.tester.domain.APIRepository;
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
    private APIRepository repository;
    private Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.exit(0);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("starting first run");
        
    }
}
