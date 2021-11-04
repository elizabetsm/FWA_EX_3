package edu.school_21.cinema.servlets;

import edu.school_21.cinema.models.User;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@WebServlet(value = {"/images/*"}, name = "ShowPicture")
public class ShowPicServlet extends HttpServlet {
    public ShowPicServlet(){}

    private String pathToPicture = null;

    @Override
    public void init(ServletConfig config) throws ServletException{
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        pathToPicture = (String) springContext.getBean("pathToPic");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        User user  = (User)req.getSession().getAttribute("user");
        byte[] fileContent = FileUtils.readFileToByteArray(new File(
                pathToPicture + user.getPhoneNumber() + req.getPathInfo()));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//        File file = new File(pathToPicture + user.getPhoneNumber() + req.getRequestURI());
        req.getSession().setAttribute("picture", encodedString);
//        System.out.println(req.getSession().getAttribute("picture"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/showPicture.jsp");
        dispatcher.forward(req, resp);

    }
}
