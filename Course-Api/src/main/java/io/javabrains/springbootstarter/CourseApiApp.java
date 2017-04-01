package io.javabrains.springbootstarter;

import io.javabrains.springbootstarter.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sande on 3/31/2017.
 */
@SpringBootApplication
public class CourseApiApp
{
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(ApplicationConfiguration.class);
        app.run(CourseApiApp.class, args);
    }
}
