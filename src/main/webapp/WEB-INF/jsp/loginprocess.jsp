<%--
  Created by IntelliJ IDEA.
  User: lizka
  Date: 19.10.2021
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>

<%@include file="logIn.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="edu.school_21.cinema.repositories.UserDaoImpl"%>
<%@page import="edu.school_21.cinema.repositories.UpdatableBCrypt" %>


<%
//    obj.setPhoneNumber(request.getParameter("email"));
//    obj.setPass(request.getParameter("password"));
    boolean status=UpdatableBCrypt.checkPassword(
            request.getParameter("password"), UserDaoImpl.readUser(request.getParameter("email")).getPass());
    if(status){
        System.out.println("You r successfully logged in");
//        out.println("You r successfully logged in");
        session.setAttribute("session","name");
    }
    else
    {
        System.out.println("Sorry, email or password error");
    }
%>
