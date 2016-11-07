package util;

/**
 * Created by Prajwal on 11/6/2016.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {  //connection to database PhoneBookDb
    Statement stmt=null;

    private final String USERNAME="root";
    private final String PASSWORD="root";
    private final String CON_STRING="jdbc:mysql://localhost:3306/efind";

    String driverClassName="com.mysql.jdbc.Driver";

    private static ConnectionManager connectionmanager=null;

    public ConnectionManager(){
        try{
            Class.forName(driverClassName);

        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        Connection con=null;
        con=DriverManager.getConnection(CON_STRING,USERNAME,PASSWORD);
        return con;
    }
}



