package util;


import model.Users;

import java.sql.*;

/**
 * Created by Prajwal on 11/6/2016.
 */
public class DataHandler {
    public ResultSet databaseResult(Connection c, String query) throws SQLException{
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        return rs;
    }

    public void databaseDelete(Connection c,String query) throws SQLException {
        Statement stmt=c.createStatement();
        stmt.executeUpdate(query);
    }
    public  int databaseInsert(Connection c, Users u) throws SQLException{

        int rowsaffected=0;
        try{

            String query="INSERT INTO users (username,firstname,lastname,email_id,password,telephone,account_type) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = c.prepareStatement(query);


            statement.setString(1, u.getUsername());
            statement.setString(2,u.getFirstName());
            statement.setString(3, u.getLastName());
            statement.setString(4, u.getEmailId());
            statement.setString(5, u.getPassword());
            statement.setString(6, u.getTelephone());
            statement.setString(7, u.getAccountType().toString());


            statement.execute();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            c.close();
        }
        return rowsaffected;
    }

    public void databaseUpdate(Connection c, Users u) throws SQLException{

        try{

            String query="UPDATE contactDb SET  first_name=?,last_name=?,phone_number=?,company_name=?,state=?,city=?,street=?,building_no=? WHERE sn=?";
            PreparedStatement statement = c.prepareStatement(query);


            statement.setString(1, u.getUsername());
            statement.setString(2, u.getFirstName());
            statement.setString(3, u.getLastName());
            statement.setString(4, u.getEmailId());
            statement.setString(5, u.getPassword());
            statement.setString(6, u.getTelephone());
            statement.setString(7, u.getAccountType().toString());
            statement.executeUpdate();
       }


        catch(SQLException e){
            e.printStackTrace();

        }
        finally{
            c.close();
        }
    }

}


