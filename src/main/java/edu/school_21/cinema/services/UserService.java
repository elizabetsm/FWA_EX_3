package edu.school_21.cinema.services;

import edu.school_21.cinema.models.User;
import edu.school_21.cinema.repositories.UserDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.sasl.AuthenticationException;

public class UserService {
    private UserDaoImpl userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDaoImpl userDao, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    public void saveUser(User user) throws AuthenticationException {
        if (userDao.getUser(user.getPhoneNumber()) == null) {
            user.setPass(passwordEncoder.encode(user.getPass()));
            userDao.createUser(user);
        } else {
            throw new AuthenticationException();
        }
    }

    public void updateUser(User user) {
        userDao.saveAttribute(user);
    }

    public User signIn(String phoneNum, String password) throws AuthenticationException {
        User user = userDao.getByPhoneNum(phoneNum);
        if (user == null) {
            throw new AuthenticationException("user not found");
        } else if (passwordEncoder.matches(password, user.getPass())) {
            return user;
        } else {
            System.out.println("Exeption!! password not match");
            throw new AuthenticationException("password incorrect");
        }
    }

    public User getUserByPhoneNum(String phoneNum) {
        return userDao.getUser(phoneNum);
    }
}
