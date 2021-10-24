package edu.school_21.cinema.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class SuccLogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
//        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        req.setAttribute("name", session.getAttribute("name"));
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
        dispatcher.forward(req, resp);

//        String user = (String)session.getAttribute("name");
//        out.println("Hello "+user);
    }
}
