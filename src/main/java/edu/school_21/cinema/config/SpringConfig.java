package edu.school_21.cinema.config;//package ed  u.schx/ool_21.cinema.config;

import edu.school_21.cinema.repositories.UserDaoImpl;
import edu.school_21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration


import javax.sql.DataSource;

//import javax.sql.DataSource;
//
@Configuration
@ComponentScan("edu.school_21.cinema")
@PropertySource("../application.properties")
public class SpringConfig {

//    private final ApplicationContext applicationContext;

//    @Autowired
//    public SpringConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }

    @Value("${datasource.driver}")
    private String driverClassName;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.usrname}")
    private String userName;
    @Value("${datasoruce.password}")
    private String password;
    @Value("${storage.path}")
    private String pathTopic;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public UserService userService(UserDaoImpl userDao, PasswordEncoder passwordEncoder) {
        return new UserService(userDao, passwordEncoder);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("pathToPic")
    public String getPathTopic(){return pathTopic;}
//    @Bean
//    public UserDAO userDaoConfig(){
//        return new UserDAO(jdbcTemplate());
//    }

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