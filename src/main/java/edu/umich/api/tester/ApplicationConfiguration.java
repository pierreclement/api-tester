package edu.umich.api.tester;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Data
@Configuration
public class ApplicationConfiguration {

    @Value("${somekey.somevaluea}")
    private String somevaluea;

    private Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");
    @Autowired
    private Environment env;

    @PostConstruct
    private void log() {
        logger.debug("somevaluea - " + this.somevaluea);
    }
}
