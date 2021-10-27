package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        UserDaoImpl.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO users(first_name, last_name, phone_number, password) VALUES(?, ?, ?,?)",
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getPass());
    }

    @Override
    public User getByPhoneNum(String phoneNum) {
        return jdbcTemplate.query("select * from users where phone_number=?",
                new UserMapper(), phoneNum).stream().findAny().orElse(null);
    }

//    public void createUser(String firstname, String lastname, String phoneNum, String pass){
//        jdbcTemplate.update("insert into users(first_name, last_name, phone_number, password)" +
//                "values(?, ?, ?,?)", firstname, lastname, phoneNum, pass);
//    }
//
//    public static User readUser(String phoneNum){
//    }
}
