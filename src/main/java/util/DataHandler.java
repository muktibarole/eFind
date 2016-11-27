package util;


import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prajwal on 11/6/2016.
 */
public class DataHandler {
    public List databaseResult(Connection c, String query) throws SQLException{
        List<Users>list=new ArrayList();
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
            while(rs.next()) {

                /*System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getInt(1));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(2));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(3));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(4));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(5));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(6));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(7));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(8));
                System.out.println("newwwwwwwwwwwwwwwwwwwww");*/
                Users user=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                list.add(user);
            }
        }
        catch(NullPointerException n){n.printStackTrace();}
        finally {
            c.close();
        }
        return list;
    }

    public void databaseDelete(Connection c,String query) throws SQLException {
        Statement stmt=c.createStatement();
        stmt.executeUpdate(query);
    }
    public  int databaseInsert(Connection c, Users u) throws SQLException{

        int uid=0;
        try{

            String query="INSERT INTO users (username,firstname,lastname,email_id,password,telephone,account_type) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);


            statement.setString(1, u.getUsername());
            statement.setString(2,u.getFirstName());
            statement.setString(3, u.getLastName());
            statement.setString(4, u.getEmailId());
            statement.setString(5, u.getPassword());
            statement.setString(6, u.getTelephone());
            statement.setString(7, u.getAccountType().toString());


            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            uid = rs.getInt(1);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            c.close();
        }
        return uid;
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


