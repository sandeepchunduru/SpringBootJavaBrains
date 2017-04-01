package io.javabrains.springbootstarter.config;

import io.javabrains.springbootstarter.service.TopicService;
import io.javabrains.springbootstarter.service.impl.TopicServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sande on 3/31/2017.
 */
@Configuration
public class ApplicationConfiguration
{
    @Bean
    public TopicService topicService()
    {
        return new TopicServiceImpl();
    }
}
