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
        boolean usernameIsaAvailable=false;
        String username= request.getParameter("username").trim();
        String email= request.getParameter("email").trim();
        String password= request.getParameter("password").trim();
        String repassword= request.getParameter("repassword").trim();
        String telephone =request.getParameter("telephone").trim();
        String accountType =request.getParameter("accountType").trim();
        String usernameValidateQuery="SELECT  * FROM users WHERE username ='"+username+"' LIMIT 1";

        //String accountType= (account.equals("Student"))?AccountType.student:AccountType.faculty;
        //AccountType accountType= AccountType.faculty;

        Users users=new Users(username,email,password,telephone,accountType);

        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;


        try{
            Connection con =connectionManager.getConnection();
            if(con==null)
                check = false;
            usernameIsaAvailable=dataHandler.usernameIsavailabe(con,usernameValidateQuery);
            if (usernameIsaAvailable)
            uid = dataHandler.databaseInsert(con,users);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (!usernameIsaAvailable){
            response.sendRedirect("index.html");
        }
        else {
            users.setUid(uid);
            System.out.println("username available "+usernameIsaAvailable);
            HttpSession session = request.getSession();
            session.setAttribute("users", users);
            if (accountType.equalsIgnoreCase("student"))
                response.sendRedirect("Profile_stu.jsp");
            else
                response.sendRedirect("Profile_fac.jsp");
        }

}

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
