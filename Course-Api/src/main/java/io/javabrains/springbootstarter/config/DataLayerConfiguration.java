package io.javabrains.springbootstarter.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by sande on 3/31/2017.
 */
@Configuration
public class DataLayerConfiguration
{

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource()
    {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("spring.database.driverClassName"));
        config.setJdbcUrl(env.getProperty("dataSource.url"));
        config.setUsername(env.getProperty("dataSource.userName"));
        config.setPassword(env.getProperty("dataSource.password"));
        config.setMinimumIdle(5);
        config.setConnectionTestQuery("select 1 from dual");
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }


}
