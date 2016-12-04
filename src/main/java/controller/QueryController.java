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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Prajwal on 11/27/2016.
 */
@WebServlet(name = "QueryController")
public class QueryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        Map<Users, Profile> userMap= new LinkedHashMap<Users, Profile>();
        Map<String, Integer> map=new LinkedHashMap();
        String query1=null;
        System.out.println("reached here");
        String column=request.getParameter("col").trim();
        if(column.equals("gpa")||column.equals("skills"))
              query1="select users.*,profile.* from users inner join profile on users.username=profile.username order by "+column+" desc ";
        else{
            query1="select department, COUNT("+column+") as count FROM profile group by "+column;
        }
        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        ResultSet rs=null;
        Connection con=null;
        try{
            con =connectionManager.getConnection();
            if(con==null)
                check = false;
            if(column.equals("gpa")||column.equals("skills"))
                userMap=dataHandler.databaseResult(con,query1);
            else
                map=dataHandler.getRowCountWithColumnValue(con,query1);
            System.out.println("hhhhhhhhhhhhhhhh111"+userMap.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("fffffffffffff"+ userMap.size());
        session.setAttribute("userMap",userMap);
        session.setAttribute("dataMap",map);
        response.sendRedirect("Dashboard.jsp");
    }
}
