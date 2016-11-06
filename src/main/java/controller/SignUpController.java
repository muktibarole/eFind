package controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

/**
 * Created by Prajwal on 11/4/2016.
 */
public class SignUpController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String firstName= request.getParameter("firstname");
        System.out.println(firstName);
        String lastName= request.getParameter("lastname");
        System.out.println(lastName);
        String username= request.getParameter("username");
        System.out.println(username);
        String email= request.getParameter("email");
        System.out.println(email);
        String password= request.getParameter("password");
        System.out.println(password);


}

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName= request.getParameter("firstname");
        System.out.println(firstName);
        String lastName= request.getParameter("lastname");
        System.out.println(lastName);
        String username= request.getParameter("username");
        System.out.println(username);
        String email= request.getParameter("email");
        System.out.println(email);
        String password= request.getParameter("password");
        System.out.println(password);

    }
}
