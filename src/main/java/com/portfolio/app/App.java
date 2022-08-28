package com.portfolio.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "RunningEventsApp API", version = "0.1", description = "This is API description"))
@SecurityScheme(name = "Basic header authorization", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

//https://www.toptal.com/spring/top-10-most-common-spring-framework-mistakes