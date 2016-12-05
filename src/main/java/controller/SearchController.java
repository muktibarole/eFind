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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Prajwal on 12/4/2016.
 */
public class SearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        String search = request.getParameter("search").trim();
        Map<Users, Profile> map=new LinkedHashMap<Users, Profile>();
        String query="SELECT users.*,profile.* from users\n" +
                "inner join profile on profile.uid=users.uid\n" +
                "where( firstname LIKE '%"+search+"%' or lastname like '%"+search+"%' or department like '%"+search+"%' or skills like '%"+search+"%' or projects like '%"+search+"%' or interest like '%"+search+"%' or program like '%"+search+"%')";
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            map=dataHandler.databaseResult(con,query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        session.setAttribute("foreignMap",map);
        response.sendRedirect("Dashboard.jsp");
    }
}
