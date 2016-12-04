package controller;

import model.Profile;
import model.Users;
import util.ConnectionManager;
import util.DataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Prajwal on 11/20/2016.
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users=null;
        Map<Users,Profile> userMap= new LinkedHashMap<Users, Profile>();
        //Set<Users>s=new TreeSet<Users>();
        String username= request.getParameter("username");
        String userQuery="SELECT  * FROM users WHERE username ='"+username+"' LIMIT 1";;
        String password= request.getParameter("password");
        HttpSession session=request.getSession();

        String query="select users.*,profile.* from users inner join profile on users.username=profile.username where users.username='"+username+"' and users.password='"+password+"'";
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            users=dataHandler.getUsers(con,userQuery);
            userMap=dataHandler.databaseResult(con,query);
            System.out.println("hhhhhhhhhhhhhhhh"+userMap.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (userMap.size()==0&& users!=null){
            session.setAttribute("users",users);
            if (users.getAccountType().equalsIgnoreCase("student"))
                response.sendRedirect("Profile_stu.jsp");
            else
                response.sendRedirect("Profile_fac.jsp");
        }
        else if (userMap.size()==0){
            response.sendRedirect("index.html");
        }
        else {
            for (Users userKey : userMap.keySet()) {
                // System.out.println( key );
                session.setAttribute("users", userKey);
                session.setAttribute("profile", userMap.get(userKey));
            }
            response.sendRedirect("Dashboard.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
