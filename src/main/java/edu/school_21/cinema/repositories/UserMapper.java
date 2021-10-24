package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        return new User(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("phone_number"),
                resultSet.getString("password"));
    }
}

