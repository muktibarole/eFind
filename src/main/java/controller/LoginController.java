package controller;

import model.Users;
import util.ConnectionManager;
import util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Prajwal on 11/20/2016.
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List <Users>userList= new ArrayList<Users>();
        String username= request.getParameter("username");
        String password= request.getParameter("password");

        String query="select * from users where username='"+username+"' and password='"+password+"'";
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            userList=dataHandler.databaseResult(con,query);
            System.out.println("hhhhhhhhhhhhhhhh"+userList.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (userList.size()==0){
            response.sendRedirect("index.html");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
