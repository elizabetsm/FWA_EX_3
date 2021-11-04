package edu.school_21.cinema.servlets;

import edu.school_21.cinema.models.SignModel;
import edu.school_21.cinema.models.User;
import edu.school_21.cinema.repositories.UpdatableBCrypt;
import edu.school_21.cinema.repositories.UserDaoImpl;
import edu.school_21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.security.sasl.AuthenticationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/signup", name = "SignUp", description = "Sing")
public class SignUpServlet extends HttpServlet {
    public SignUpServlet(){}

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
//        super.init(config);
//        this.userDaoImpl = (UserDaoImpl)config.getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/html/signUp.html").forward(req, resp);
        System.out.println("Signout-get");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String firstName = request.getParameter("firstname");
        String password = request.getParameter("pass");
        String lastName = request.getParameter("lastname");
        String phoneNum = request.getParameter("phoneNum");
        try {
//            SignModel signModel = new SignModel(request.getRemoteAddr());
            List<SignModel> list = new ArrayList<>();
            list.add(new SignModel(request.getRemoteAddr()));
            User user = new User(firstName, lastName, phoneNum, password);
            userService.saveUser(user);
            user = userService.getUserByPhoneNum(phoneNum);
            user.setSignModels(list);
            userService.updateUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/profile");
        } catch (AuthenticationException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/signUp.html");
            dispatcher.forward(request, response);
        }
    }
}
