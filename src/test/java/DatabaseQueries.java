import model.AccountType;
import model.Users;
import org.junit.Test;
import util.ConnectionManager;
import util.DataHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Prajwal on 11/6/2016.
 */


public class DatabaseQueries {

    @Test
    public void write(){
        Users users=new Users("prajwalfc","prajwal_k@live.com","prajwalk","3479719306", "Student");

        ConnectionManager connectionManager=new ConnectionManager();
        boolean check=true;
        DataHandler dataHandler=new DataHandler();

        try{
            Connection con =connectionManager.getConnection();
            if(con==null)
                check = false;
            dataHandler.databaseInsert(con,users);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
