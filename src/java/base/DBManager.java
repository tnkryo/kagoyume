package base;
/**
 *
 * @author kobayashi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static Connection getConnection(){
    Connection con = null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db","kbys","sw");
    System.out.print("DBConnected!!");
    return con;
}catch(ClassNotFoundException e){
    throw new IllegalMonitorStateException();
} catch(SQLException e){
    throw new IllegalMonitorStateException();
}
}
}
