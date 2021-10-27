package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;

public interface UserDao {
    void createUser(User user);

    User getByPhoneNum(String phoneNum);
}
