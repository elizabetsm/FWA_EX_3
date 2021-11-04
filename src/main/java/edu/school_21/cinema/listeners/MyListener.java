package edu.school_21.cinema.listeners;

import edu.school_21.cinema.config.SpringConfig;
import edu.school_21.cinema.models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        User user = new User();
        System.out.println("User: " + user.getID());
        ServletContext ctx = sce.getServletContext();
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ctx.setAttribute("springContext", context);
    }
}
