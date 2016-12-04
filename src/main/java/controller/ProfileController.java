package controller;

import model.Profile;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Prajwal on 12/4/2016.
 */

public class ProfileController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uid = request.getParameter("uid").trim();
        Profile profile=null;
        String query="select *from profile where uid='"+uid+"'";
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            profile=dataHandler.getProfile(con,query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        session.setAttribute("foreignProfile",profile);
        //response.sendRedirect("Profile.jsp?uid="+uid);
        response.sendRedirect("Profile.jsp");
    }
    }

