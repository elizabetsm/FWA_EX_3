package edu.school_21.cinema.servlets;


import edu.school_21.cinema.models.User;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet(value = {"/profile"}, name = "Profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class SuccLogInServlet extends HttpServlet {

    public SuccLogInServlet(){}

    private String pathToPicture = null;

    @Override
    public void init(ServletConfig config) throws ServletException{
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        pathToPicture = (String) springContext.getBean("pathToPic");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user  = (User)session.getAttribute("user");
        File pathToPic = new File(pathToPicture + user.getPhoneNumber());
        pathToPic.mkdir();
        req.getSession().setAttribute("pathImages", pathToPic);
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        HttpSession session = req.getSession();
        User user  = (User)session.getAttribute("user");
        Part filePart = req.getPart("file");
        File pathToPic = new File(pathToPicture + user.getPhoneNumber());
        if (filePart != null){
            String fileName = filePart.getSubmittedFileName();
            for (Part part : req.getParts()) {
                part.write(pathToPic + File.separator+ fileName);
            }
        }
        req.getSession().setAttribute("pathImages", pathToPic);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
        dispatcher.forward(req, resp);
    }
}
