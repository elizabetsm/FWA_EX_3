package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setPass(resultSet.getString("password"));

        return user;

//        return new User(resultSet.getString("first_name"),
//                resultSet.getString("last_name"),
//                resultSet.getString("phone_number"),
//                resultSet.getString("password"));
    }
}

