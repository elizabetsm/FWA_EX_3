package edu.school_21.cinema.servlets;

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
import javax.swing.undo.AbstractUndoableEdit;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/signin"}, name = "SignIn", description = "Sing In")
public class SignInServlet extends HttpServlet{

    public SignInServlet(){}

    private UserService userService;

    @Override
    public void init (ServletConfig config ) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        this.userDAO = (UserDAO)config.getServletContext().getAttribute("userDAO");
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/html/signIn.html").forward(req, resp);
//        System.out.println("signin-get");
//        RequestDispatcher view = req.getRequestDispatcher("/WEB_INF/logIn.jsp");
//        view.include(req, resp);

        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/html/signIn.html");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String userName = request.getParameter("phoneNum");
        String password = request.getParameter("pass");
        try {
            User user = userService.signIn(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/profile");
        } catch (AuthenticationException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/signIn.html");
            dispatcher.forward(request, response);
        }

//        response.setContentType("text/html");
//        String phoneNum = request.getParameter("phoneNum");
//        String pass = request.getParameter("pass");
//        System.out.println("point22222");
//        User user = UserDaoImpl.readUser(phoneNum);
//        System.out.println("Point!!!!!1");
//        if (user == null){
//            request.getRequestDispatcher("/WEB-INF/html/signIn.html").forward(request, response);
//        }
//        else if (UpdatableBCrypt.checkPassword(pass, user.getPass())){
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            RequestDispatcher rs = request.getRequestDispatcher("/welcome");
//            rs.forward(request, response);
//        } else {
//            request.setAttribute("message", "Unknown username/password. Please retry.");
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

