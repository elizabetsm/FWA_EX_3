package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;

public interface UserDao {
    void createUser(User user);

    public void saveAttribute(User user);

    public User getUser(String phoneNum);

    User getByPhoneNum(String phoneNum);
}
