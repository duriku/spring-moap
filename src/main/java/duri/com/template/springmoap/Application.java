package duri.com.template.springmoap;

import duri.com.template.springmoap.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Config configFromJava;

    @Value("${test.bighello}")
    private String valueFromProperty;

    @RequestMapping("/")
    String home() {
        logger.info("### Invoked method 'home' ###");

        StringBuilder sb = new StringBuilder();
        return sb.append(valueFromProperty)
                    .append("\n")
                    .append("Created by ")
                    .append(configFromJava.getFirstname() + " " + configFromJava.getLastname())
                .toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}