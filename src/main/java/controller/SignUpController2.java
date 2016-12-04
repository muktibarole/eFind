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
import java.sql.SQLException;

/**
 * Created by Prajwal on 12/3/2016.
 */
public class SignUpController2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int count=0;
        System.out.println("hhhhhhhhhhhhhhhhhhhhh");
        HttpSession session=request.getSession();
        Users users= (Users)session.getAttribute("users");
        int uid=users.getUid();
        String accountType=users.getAccountType();
        String username=users.getUsername();
        String firstname= request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String tnumber= request.getParameter("tnumber");
        String program= request.getParameter("program");
        String department=request.getParameter("department");
        String gpa=request.getParameter("gpa");
        String skills=request.getParameter("skills");
        String interest=request.getParameter("interest");
        String projects=request.getParameter("projects");

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(tnumber);
        System.out.println(program);
        System.out.println(department);
        System.out.println(gpa);
        System.out.println(skills);
        System.out.println(interest);
        System.out.println(projects);


        System.out.println("pppppppppppppppppppppppp"+users.getUid()+"1111"+username);

        Profile profile=new Profile(uid,username,firstname,lastname,tnumber,program,department,gpa,skills,interest,projects);

        DataHandler dataHandler=new DataHandler();
        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;

        try{
            Connection con =connectionManager.getConnection();
            if(con==null)
                check = false;
            count= dataHandler.databaseInsert2(con,profile);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //response.sendRedirect("Dashboard.jsp");\

        //doGet(request,response);
       session.setAttribute("profile",profile);
        response.sendRedirect("Dashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
