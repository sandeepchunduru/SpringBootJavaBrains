package com.chunduru.services;

import com.chunduru.TopicsClient;

/**
 * Created by sande on 4/1/2017.
 */
public class TopicsDetails
{
    public String getSelectedTopic(String topicId)
    {
        TopicsClient topicsClient = new TopicsClient();
        String selectedCourse = topicsClient.getTopicName(topicId);

        return selectedCourse;
    }

}
