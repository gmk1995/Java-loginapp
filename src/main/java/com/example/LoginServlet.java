package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform the login process here
        // Example: check if the username and password match with the hardcoded values
        if ("admin".equals(username) && "password".equals(password)) {
            // If the login is successful, redirect the user to the home page
            extracted(response);
        } else {
            // If the login is not successful, redirect the user back to the login page
            response.sendRedirect("login.jsp");
        }
    }

    private void extracted(HttpServletResponse response) throws IOException {
        response.sendRedirect("home.jsp");
    }
}
