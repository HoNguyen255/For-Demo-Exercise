package Exercise.BankManagementSystem;
import java.sql.*;
public class Conn {

    Connection c = null;
    Statement s;
    public Conn(){
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdatabase", "root", "Honguyen2505@");
            s = c.createStatement();
//            if (c !=null){
//                System.out.println("database is connected");
//            }
        } catch (Exception e){
            System.out.println("Not connected");
        }
    }
}
