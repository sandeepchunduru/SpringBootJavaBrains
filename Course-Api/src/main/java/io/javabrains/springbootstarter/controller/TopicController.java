package io.javabrains.springbootstarter.controller;

import io.javabrains.springbootstarter.entities.Topics;
import io.javabrains.springbootstarter.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by sande on 3/31/2017.
 */
@RestController
@RequestMapping("/topics")
public class TopicController
{

    @Autowired
    private TopicService topicService;

    @RequestMapping(value= "/getAllTopics")
    public List<Topics> getAllTopics()
    {
        return topicService.getAllTopics();
    }

    @RequestMapping(value= "/getTopic/{topicId}")
    public Topics getAllTopics(@PathVariable final  String topicId)
    {
        return topicService.getTopic(topicId);
    }

    @RequestMapping(value= "/addNewTopic", method = RequestMethod.POST)
    public void addNewTopic(@RequestBody Topics topic)
    {
        topicService.addNewTopic(topic);
    }

    @RequestMapping(value= "/updateTopic/{topicId}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topics topic, @PathVariable final  String topicId)
    {
        topicService.updateTopic(topic, topicId);
    }

    @RequestMapping(value= "/deleteTopic/{topicId}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable final  String topicId)
    {
        topicService.deleteTopic(topicId);
    }



}
