package edu.school_21.cinema.listeners;

import edu.school_21.cinema.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {


    private JdbcTemplate jdbcTemplate;

    public MyListener(){}
    @Autowired
    public MyListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
        sce.getServletContext().setAttribute("userDAO", new UserDAO(jdbcTemplate));
    }

//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        ServletContextListener.super.contextDestroyed(sce);
//    }
}
