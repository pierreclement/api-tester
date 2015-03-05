package edu.umich.api.tester;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Data
@EnableJpaRepositories
public class ApplicationConfiguration {

    @Value("${frequency}")
    private String frequency;

    private Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");
    @Autowired
    private Environment env;

    @PostConstruct
    private void log() {
        logger.debug("frequency - " + this.frequency);
    }
}