package duri.com.template.springmoap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Duri on 2014.12.10..
 */

@Component
@ConfigurationProperties(prefix = "application.developer")
public class Config {

    private String firstname;

    private String lastname;

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
