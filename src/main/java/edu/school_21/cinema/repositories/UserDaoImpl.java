package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.SignModel;
import edu.school_21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    private UserExtractor userExtractor;
    private final String SQL_QUERY = "SELECT * FROM users LEFT JOIN signmodel s on users.id = s.user_id WHERE phone_number='2'";

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
    public void saveAttribute(User user) {
        List<SignModel> list = user.getSignModels();
        SignModel signModel = list.get(list.size() - 1);
        jdbcTemplate.update("INSERT INTO signModel(user_id, ip, date) VALUES(?, ?, ?)",
                user.getID(),
                signModel.getIp(),
                signModel.getDate());
    }

    @Override
    public User getByPhoneNum(String phoneNum) {
        return jdbcTemplate.query(SQL_QUERY, userExtractor);
    }

    @Override
    public User getUser(String phoneNum) {
        return jdbcTemplate.query("select * from users where phone_number=?",
                new UserMapper(), phoneNum).stream().findAny().orElse(null);
    }

//    List<Employee> getByPhoneNum(List<Integer> ids) {
//        String inSql = String.join(",", Collections.nCopies(ids.size(), "?"));
//
//        List<Employee> employees = jdbcTemplate.query(
//                String.format("SELECT * FROM EMPLOYEE WHERE id IN (%s)", inSql),
//                ids.toArray(),
//                (rs, rowNum) -> new Employee(rs.getInt("id"), rs.getString("first_name"),
//                        rs.getString("last_name")));
//
//        return employees;
//    }

//    public void createUser(String firstname, String lastname, String phoneNum, String pass){
//        jdbcTemplate.update("insert into users(first_name, last_name, phone_number, password)" +
//                "values(?, ?, ?,?)", firstname, lastname, phoneNum, pass);
//    }
//
//    public static User readUser(String phoneNum){
//    }
}

@Component
class UserExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User();
        List<SignModel> list = new ArrayList<>();

        while (resultSet.next()) {
            if (user.getID() == 0) {
                user.setID(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setPass(resultSet.getString("password"));
            }
            list.add(new SignModel(resultSet.getString("ip"), resultSet.getDate("date")));
        }
        user.setSignModels(list);
        return user;
    }
}
