package edu.school_21.cinema.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DayOfWeek;

import edu.school_21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDAO {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        UserDAO.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(String firstname, String lastname, String phoneNum, String pass){
        jdbcTemplate.update("insert into users(first_name, last_name, phone_number, password)" +
                "values(?, ?, ?,?)", firstname, lastname, phoneNum, pass);
    }

    public static User readUser(String phoneNum){
        return jdbcTemplate.query("select * from users where phone_number=?",
                new UserMapper(), phoneNum).stream().findAny().orElse(null);
    }
}
