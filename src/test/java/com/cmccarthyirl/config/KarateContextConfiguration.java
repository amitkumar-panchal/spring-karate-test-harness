package com.cmccarthyirl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({
        "com.cmccarthy"
})
@PropertySource("classpath:/application.properties")
public class KarateContextConfiguration {

}
