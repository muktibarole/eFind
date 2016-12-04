package util;


import model.Profile;
import model.Users;

import java.sql.*;
import java.util.*;

/**
 * Created by Prajwal on 11/6/2016.
 */
public class DataHandler {

    public Map databaseResult(Connection c, String query) throws SQLException{
        Map<Users, Profile> map=new LinkedHashMap<Users, Profile>();
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
            while(rs.next()) {

                /*System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(9));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(10));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(11));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(12));*/
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString("gpa"));
               /* System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(14));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(15));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(16));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(17));
                System.out.println("newwwwwwwwwwwwwwwwwwwww");*/
                Users user=new Users(rs.getInt("uid"),rs.getString("username"),rs.getString("email_id"),rs.getString("password"),rs.getString("telephone"),rs.getString("account_type"));
                Profile profile=new Profile(rs.getInt("uid"),rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("tnumber"),rs.getString("program"),rs.getString("department"),rs.getString("gpa"),rs.getString("skills"),rs.getString("interest"),rs.getString("projects"));
                map.put(user,profile);
            }
        }
        catch(NullPointerException n){n.printStackTrace();}
        finally {
            c.close();
        }
        return map;
    }

    public void databaseDelete(Connection c,String query) throws SQLException {
        Statement stmt=c.createStatement();
        stmt.executeUpdate(query);
    }
    public  int databaseInsert(Connection c, Users u) throws SQLException{

        int uid=0;
        try{

            String query="INSERT INTO users (username,email_id,password,telephone,account_type) VALUES (?,?,?,?,?)";
            PreparedStatement statement = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);


            statement.setString(1, u.getUsername());
            statement.setString(2,u.getEmailId());
            statement.setString(3,u.getPassword()) ;
            statement.setString(4,u.getTelephone()) ;
            statement.setString(5,u.getAccountType()) ;




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

    public  int databaseInsert2(Connection c, Profile p) throws SQLException{

        int count=0;
        boolean i=false;
        try{

            String query="INSERT INTO profile (uid,firstName,lastName,userName,tnumber,department,program,gpa,skills,projects,interest) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);


            statement.setInt(1,p.getUid());
            statement.setString(2,p.getFirstName());
            statement.setString(3,p.getLastName()) ;
            statement.setString(4,p.getUserName()) ;
            statement.setString(5,p.getTnumber()) ;
            statement.setString(6,p.getDepartment()) ;
            statement.setString(7,p.getProgram()) ;
            statement.setString(8,p.getGpa()) ;
            statement.setString(9,p.getSkills()) ;
            statement.setString(10,p.getProjects()) ;
            statement.setString(11,p.getInterest()) ;




              count=statement.executeUpdate();



        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            c.close();
        }
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkk"+count);
        return count;
    }

        public boolean usernameIsavailabe(Connection c,String query)throws SQLException{
            boolean isAvailable=true;
            System.out.println("11111111111111"+query);
            PreparedStatement statement=c.prepareStatement(query);
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                String t=rs.getString("username")+"1111111111111111111111";
                System.out.println(""+t);
            if(t==null ||t.equalsIgnoreCase("")||t.equals(null));
                isAvailable=false;

            }
            System.out.println("jjjjjjjjjjjjj"+isAvailable);
            return isAvailable;
        }

    public void databaseUpdate(Connection c, Users u) throws SQLException{

        try{

            String query="UPDATE contactDb SET  first_name=?,last_name=?,phone_number=?,company_name=?,state=?,city=?,street=?,building_no=? WHERE sn=?";
            PreparedStatement statement = c.prepareStatement(query);


            statement.setString(1, u.getUsername());
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

    public void processQuery(Connection con, String query)throws SQLException{
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try {
            while (rs.next()) {
            }
        }
        catch (NullPointerException s){

        }
        finally {
            con.close();
        }
    }

    public Users getUsers(Connection c, String query) throws SQLException{
        Users user=null;
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
            while(rs.next()) {

                /*System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(9));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(10));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(11));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(12));*/
                //System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString("gpa"));
               /* System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(14));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(15));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(16));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(17));
                System.out.println("newwwwwwwwwwwwwwwwwwwww");*/
                 user=new Users(rs.getInt("uid"),rs.getString("username"),rs.getString("email_id"),rs.getString("password"),rs.getString("telephone"),rs.getString("account_type"));

            }
        }
        catch(NullPointerException n){n.printStackTrace();}

        return user ;
    }

    public Map getRowCountWithColumnValue(Connection c,String query)  throws SQLException{
        Map<String, Integer> map=new LinkedHashMap();
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
                while(rs.next()){
                map.put(rs.getString("department"),rs.getInt("count"));
                }
        }
        catch(NullPointerException n){}
        finally{
            c.close();
        }
        return map;
    }
    public List getProfileList(Connection c, String query) throws SQLException{
        List<Profile>profileList=new LinkedList<Profile>();
        Profile profile=null;
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
            while(rs.next()) {

                /*System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(9));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(10));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(11));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(12));*/
                //System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString("gpa"));
                System.out.println("zzzzzzzzzzzzzzzzzzz" + rs.getString("username"));
               /* System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString());
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(16));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(17));
                System.out.println("newwwwwwwwwwwwwwwwwwwww");*/
                 profile=new Profile(rs.getInt("uid"),rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("tnumber"),rs.getString("program"),rs.getString("department"),rs.getString("gpa"),rs.getString("skills"),rs.getString("interest"),rs.getString("projects"));
                profileList.add(profile);

            }
        }
        catch(NullPointerException n){n.printStackTrace();}
        finally{
            c.close();
        }

        return profileList ;
    }

    public Profile getProfile(Connection c, String query) throws SQLException{
        Profile profile =null;
        Statement stmt=c.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        try{
            while(rs.next()) {

                /*System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(9));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(10));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(11));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(12));*/
                //System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString("gpa"));
                System.out.println("zzzzzzzzzzzzzzzzzzz" + rs.getString("username"));
               /* System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString());
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(16));
                System.out.println("nnnnnnnnnnnnnnnnnnn" + rs.getString(17));
                System.out.println("newwwwwwwwwwwwwwwwwwwww");*/
                profile=new Profile(rs.getInt("uid"),rs.getString("username"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("tnumber"),rs.getString("program"),rs.getString("department"),rs.getString("gpa"),rs.getString("skills"),rs.getString("interest"),rs.getString("projects"));

            }
        }
        catch(NullPointerException n){n.printStackTrace();}
        finally{
            c.close();
        }

        return profile ;
    }
}


