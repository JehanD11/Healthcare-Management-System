package com.example.healthcare_management_system.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.*;
import com.example.healthcare_management_system.DAO.*;
import com.example.healthcare_management_system.models.*;
import com.example.healthcare_management_system.utils.databaseConnection;
import com.example.healthcare_management_system.Services.*;

public class UserController extends HttpServlet {
//    private UserService userService;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        userService = new UserService();
//    }

//    private void listUsers(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
//        try {
//            req.setAttribute("users", userService.getAllUsers());
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/users.jsp");
//            requestDispatcher.forward(req, res);
//        }catch (Exception e) {
//            e.printStackTrace();
//            res.sendRedirect("error.jsp");
//        }
//    }
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        out.println("Hello " + username + "!");
    }



}
