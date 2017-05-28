package com.chunduru;

import com.chunduru.config.RestClientConfiguration;
import io.javabrains.springbootstarter.entities.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sande on 4/1/2017.
 */
@SpringBootApplication
public class RestClientApp implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(RestClientApp.class);


    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(RestClientConfiguration.class);
        app.run(RestClientApp.class, args);
    }


    @Autowired
    private TopicsClient topicsClient;

    @Override
    public void run(String... strings) throws Exception
    {
    //    Topics topics = topicsClient.getTopic("java");
     //   logger.info("**** This is the Topics Name=== " + topics.getName());
    }
}
