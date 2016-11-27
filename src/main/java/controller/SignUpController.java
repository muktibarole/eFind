package controller;

import model.AccountType;
import model.Users;
import util.ConnectionManager;
import util.DataHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 * Created by Prajwal on 11/4/2016.
 */
public class SignUpController extends javax.servlet.http.HttpServlet  {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        int uid=0;
        String username= request.getParameter("username");
        String firstName= request.getParameter("firstname");
        String lastName= request.getParameter("lastname");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        String repassword= request.getParameter("repassword");
        String telephone =request.getParameter("telephone");
        String accountType =request.getParameter("accountType");

        //String accountType= (account.equals("Student"))?AccountType.student:AccountType.faculty;
        //AccountType accountType= AccountType.faculty;

        Users users=new Users(username,firstName,lastName,email,password,telephone,accountType);

        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;

        try{
            Connection con =connectionManager.getConnection();
            if(con==null)
                check = false;
            uid = dataHandler.databaseInsert(con,users);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //response.sendRedirect("Dashboard.jsp");\
        HttpSession session =request.getSession();
        session.setAttribute("users",users);
        doGet(request,response);

}

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
