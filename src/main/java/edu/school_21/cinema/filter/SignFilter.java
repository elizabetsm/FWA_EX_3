package edu.school_21.cinema.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = {"SignIn", "SignUp"})
public class SignFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        if (session.getAttribute("user") != null) {
            resp.sendRedirect("/profile");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
