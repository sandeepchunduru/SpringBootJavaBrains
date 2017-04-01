package io.javabrains.springbootstarter.service;

import io.javabrains.springbootstarter.entities.Topics;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sande on 3/31/2017.
 */
@Service
public interface TopicService
{
    List<Topics> getAllTopics();

    Topics getTopic(String topicId);

    void addNewTopic(Topics topic);

    void updateTopic(Topics topic, String topicId);

    void deleteTopic(String topicId);
}
