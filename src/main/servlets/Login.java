package main.servlets;

import main.account.UserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserList userList = new UserList();

        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if(login == null || pass == null || login.length() == 0 || pass.length() == 0 || !userList.tryLogin(login, pass))
            resp.sendRedirect("http://localhost:8082/login.html");
        else {
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print("<html><h2>Hello, " + login + "!</h2><br/><p>You have succesfully loggged in.</p></html>");
            printWriter.close();
        }
    }
}
