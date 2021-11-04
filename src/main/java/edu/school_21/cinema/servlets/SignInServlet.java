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
import javax.swing.undo.AbstractUndoableEdit;
import java.io.IOException;
import java.util.ArrayList;
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
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/html/signIn.html");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("pass");
        try {
            List<SignModel> list;
//            list.add(new SignModel(request.getRemoteAddr()));
            User user = userService.signIn(phoneNum, password);
            list = user.getSignModels();
            list.add(new SignModel(request.getRemoteAddr()));

            userService.updateUser(user);                    //TODO исправить косяк с заполнением модли
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/profile");
        } catch (AuthenticationException e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/html/signIn.html");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

