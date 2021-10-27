package edu.school_21.cinema.filter;

import edu.school_21.cinema.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(servletNames = {"SignIn", "SignUp"})
//public class SignInFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
//        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//
//        if (session != null) {
//            User user = (User) session.getAttribute("name");
//            if (user != null) {
//                resp.sendRedirect(req.getContextPath() + "/welcome");
//                return;
//            }
//            else {
//                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//        }

//        if (requestURI.startsWith("/signIn") || requestURI.startsWith("/signUp")) {
//            if (session.getAttribute("name") != null) {
//                ((HttpServletResponse)servletResponse).sendRedirect("");
//                return;
//            }
//        }
//        else {
//            if (session.getAttribute("name") == null) {
//                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//        }

//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
