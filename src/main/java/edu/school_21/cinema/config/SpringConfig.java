package edu.school_21.cinema.config;//package edu.schx/ool_21.cinema.config;

import edu.school_21.cinema.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

//import javax.sql.DataSource;
//
@Configuration
@ComponentScan("edu.school_21.cinema")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("datasource.driver");
        dataSource.setUrl("datasource.url");
        dataSource.setUsername("datasource.usrname");
        dataSource.setPassword("datasoruce.password");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public UserDAO userDaoConfig(){
        return new UserDAO(jdbcTemplate());
    }

//    private ServletRegistration.Dynamic initSpring(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {
////        LOGGER.debug("Configuring Spring Web application context");
//        AnnotationConfigWebApplicationContext dispatcherServletConfiguration = new AnnotationConfigWebApplicationContext();
//        dispatcherServletConfiguration.setParent(rootContext);
//        dispatcherServletConfiguration.register(DispatcherServletConfiguration.class);
//
////        LOGGER.debug("Registering Spring MVC Servlet");
//        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServletConfiguration));
//        dispatcherServlet.addMapping("/*");
//        dispatcherServlet.setMultipartConfig(new MultipartConfigElement((String) null));
//        dispatcherServlet.setLoadOnStartup(1);
//        dispatcherServlet.setAsyncSupported(true);
//
//        return dispatcherServlet;
//    }
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/users");
//        dataSource.setUsername("lizka");
//        dataSource.setPassword("hidden");
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//    private final ApplicationContext applicationContext;
//
//    @Autowired
//    public SpringConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
    }
//
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
////        // Load Spring web application configuration
////        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
////        context.register(AppConfig.class);
////
////        // Create and register the DispatcherServlet
////        DispatcherServlet servlet = new DispatcherServlet(context);
////        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
////        registration.setLoadOnStartup(1);
////        registration.addMapping("/app/*");
//    }
//