package edu.school_21.cinema.filter;

import edu.school_21.cinema.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = {"Profile"})
public class ProfileFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

//        if (requestURI.startsWith("/signin") || requestURI.startsWith("/signup")) {
//            if (session.getAttribute("user") != null) {
//                ((HttpServletResponse)servletResponse).sendRedirect("/profile");
//                return;
//            }
//        }
//        else {
//            if (session.getAttribute("user") == null) {
//                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
//                return;
//            }
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
