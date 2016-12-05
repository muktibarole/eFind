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

public class ProfileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uid = request.getParameter("uid").trim();
        Map<Users,Profile> foreignMap= new LinkedHashMap<Users, Profile>();
        String query="select users.*,profile.* from users inner join profile on users.uid=profile.uid where users.uid='"+uid+"'";
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            foreignMap=dataHandler.databaseResult(con,query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        for (Users userKey : foreignMap.keySet()) {
            // System.out.println( key );
            session.setAttribute("foreignUser", userKey);
            session.setAttribute("foreignProfile", foreignMap.get(userKey));
        }
        response.sendRedirect("Profile.jsp");
    }
    }

