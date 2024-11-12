package com.example.healthcare_management_system;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class loginAndAuthentication extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


    }
}
