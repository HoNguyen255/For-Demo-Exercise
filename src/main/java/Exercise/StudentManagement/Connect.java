package Exercise.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Connect {

    Connection c = null;
    Statement s;

    public Connect() {
        try {
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root",
                    "Honguyen2505@");
            s = c.createStatement();
            // if (c !=null){
            // System.out.println("database is connected");
            // }
        } catch (Exception e) {
            System.out.println("Not connected");
        }
    }

}
