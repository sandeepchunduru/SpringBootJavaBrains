package com.chunduru.config;

import com.chunduru.TopicsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sande on 4/1/2017.
 */
@Configuration
public class RestClientConfiguration
{
    @Autowired
    Environment env;

//    @Bean
//    public TopicsClient topicsClient()
//    {
//        return new TopicsClient(env.getProperty("service.url"));
//    }

    @Bean
    public RestOperations createRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory)
    {
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(@Value("${connect.timeout}") final int connectTimeout,
                                                      @Value("${connect.timeout}") final int readTimeout)
    {
        HttpComponentsClientHttpRequestFactory http = new HttpComponentsClientHttpRequestFactory();
        http.setConnectTimeout(connectTimeout);
        http.setReadTimeout(readTimeout);
        return http;
    }


}
