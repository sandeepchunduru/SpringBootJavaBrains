package com.chunduru.view;

import com.chunduru.services.TopicsDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sande on 4/1/2017.
 */
public class ConsumeRestApis
{
    private static final Logger logger  = LoggerFactory.getLogger(ConsumeRestApis.class);
    public static final String topcId= "angular";
    public static void main(String[] args)
    {
        TopicsDetails topicsDetails = new TopicsDetails();

        String selectedTopicName = topicsDetails.getSelectedTopic(topcId);
        logger.info("*************************************************************");
        logger.info("********* SELECTED TOPIC NAME: ***************" + selectedTopicName);
        logger.info("*************************************************************");
    }

}
