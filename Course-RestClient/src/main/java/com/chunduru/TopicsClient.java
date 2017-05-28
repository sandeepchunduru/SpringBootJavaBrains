package com.chunduru;

import io.javabrains.springbootstarter.entities.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.List;

/**
 * Created by sande on 4/1/2017.
 */
@Component
public class TopicsClient
{

    @Autowired
    RestOperations restOperations;
    private final String url;
    private final String clientUri = "/topics";

    @Autowired
    public  TopicsClient(@Value("${service.url}") final String url)
    {
        this.url = url + clientUri;
    }

    public TopicsClient()
    {
        this.url = "http://localhost:8081/topics";
    }

    public List<Topics> getAllTopics()
    {
        return null;
    }

    public Topics getTopic(final String topicId)
    {
        Topics topics =  restOperations.getForObject(url + "/getTopic/{topicId}", Topics.class, topicId);
        return topics;
    }

    public String getTopicName(final String topicId)
    {
        Topics topics =  restOperations.getForObject(url + "/getTopic/{topicId}", Topics.class, topicId);
        return topics.getName();
    }

}
