package edu.school_21.cinema.servlets;


import edu.school_21.cinema.models.Auth;
import edu.school_21.cinema.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {"/profile"}, name = "Profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class SuccLogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        HttpSession session = req.getSession();
        User user  = (User)session.getAttribute("user");
//        req.setAttribute("user", user);
        Part filePart = req.getPart("file");
        File pathToPic = new File("/Users/lizka/Desktop/FWA_EX_3/" + user.getPhoneNumber());
        pathToPic.mkdir();
        if (filePart != null){
            String fileName = filePart.getSubmittedFileName();
            for (Part part : req.getParts()) {
                part.write(pathToPic + File.separator+ fileName);
            }
        }
//        System.out.println();
        req.getSession().setAttribute("pathImages", pathToPic);
        System.out.println("DO POST ID = "+ req.getSession().getAttribute("pathImages"));

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
        dispatcher.forward(req, resp);
    }
}
