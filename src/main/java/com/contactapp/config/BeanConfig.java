package com.contactapp.config;

import com.contactapp.dao.UserDao;
import com.contactapp.dao.UserDaoImpl;
import com.contactapp.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by gazi_muhib on 8/16/17.
 */

@Configuration
public class BeanConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ContactApplicationDB");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }

}
