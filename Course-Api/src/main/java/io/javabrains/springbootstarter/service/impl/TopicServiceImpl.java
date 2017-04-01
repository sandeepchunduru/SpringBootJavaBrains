package io.javabrains.springbootstarter.service.impl;

import io.javabrains.springbootstarter.entities.Topics;
import io.javabrains.springbootstarter.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by sande on 3/31/2017.
 */
public class TopicServiceImpl implements TopicService
{
    public static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void SetDataSource(DataSource dataSource)
    {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    List<Topics> topicsList = new ArrayList<Topics>(Arrays.asList(
            new Topics("spring", "spring framework", "spring discription"),
                new Topics("java", "java framework", "java discription"),
                new Topics("maven", "maven framework", "maven discription")));

    @Override
    public List<Topics> getAllTopics()
    {
        String sql = "SELECT ID, NAME, DESCRIPTION FROM TOPICS";
        Map<String, Object> param = new HashMap<String, Object>();

        List<Topics> list = jdbcTemplate.query(sql, param, new RowMapper<Topics>() {
            @Override
            public Topics mapRow(ResultSet rs, int row) throws SQLException
            {
                Topics topic = new Topics();
                topic.setId(rs.getString("ID"));
                topic.setName(rs.getString("NAME"));
                topic.setDescription(rs.getString("DESCRIPTION"));
                return topic;
            }
        });

        logger.info("getAllTopics on Insert = " + list);
        return list;
    }

    @Override
    public Topics getTopic(String topicId)
    {
        String sql = "SELECT ID, NAME, DESCRIPTION FROM TOPICS WHERE ID=:ID";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ID", topicId);
        List<Topics> list = jdbcTemplate.query(sql, param, new RowMapper<Topics>() {
            @Override
            public Topics mapRow(ResultSet rs, int row) throws SQLException
            {
                Topics topic = new Topics();
                topic.setId(rs.getString("ID"));
                topic.setName(rs.getString("NAME"));
                topic.setDescription(rs.getString("DESCRIPTION"));
                return topic;
            }
        });

        logger.info("getTopic on Insert = " + list);
        return list.get(0);
    }

    @Override
    public void addNewTopic(Topics topic)
    {
        String sql = "INSERT INTO TOPICS VALUES (:ID, :NAME, :DESCRIPTION)";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ID", topic.getId());
        param.put("NAME", topic.getName());
        param.put("DESCRIPTION", topic.getDescription());

        int updateValue = jdbcTemplate.update(sql, param);
        logger.info("addNewTopic on Insert = " + updateValue);
    }

    @Override
    public void updateTopic(Topics updatedTopic, String topicId)
    {
        String sql = "UPDATE TOPICS SET NAME = :NAME, DESCRIPTION = :DESCRIPTION WHERE ID=:ID";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ID", updatedTopic.getId());
        param.put("NAME", updatedTopic.getName());
        param.put("DESCRIPTION", updatedTopic.getDescription());

        int updateValue = jdbcTemplate.update(sql, param);
        logger.info("updateValue on Update = " + updateValue);
    }

    @Override
    public void deleteTopic(String topicId)
    {
        String sql = "DELETE FROM TOPICS WHERE ID=:ID";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ID", topicId);
        int updateValue = jdbcTemplate.update(sql, param);
        logger.info("deleteTopic on Update = " + updateValue);
       // topicsList.removeIf(t -> t.getId().equals(topicId));
    }
}
