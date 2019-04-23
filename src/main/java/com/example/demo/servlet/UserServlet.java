package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserServlet
 */
@WebServlet(name = "userServlet", urlPatterns = "/v1/api/test/customs")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = -7336220001932665687L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("custom servlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}