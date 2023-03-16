package tilegame.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection con = null;
    private static String url = "jdbc:derby://localhost:1527/podiumDB";
    private static String username = "podium";
    private static String password = "1234";
    
    
    
    static{
        // instantiate
        try{
            con = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        return con; 
    }
    
}
