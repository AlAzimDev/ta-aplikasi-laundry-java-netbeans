package Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connection {
    private static java.sql.Connection koneksi;
    public static java.sql.Connection getkoneksi(){
        if(koneksi==null){
            try {
                String url      = new String();
                String user     = new String();
                String password = new String();
                url="jdbc:mysql://localhost:3306/lyondry";
                user="root";
                password="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url,user,password);
                            
            } catch (SQLException t) {
                System.out.println("Oops! No internet");
                JOptionPane.showMessageDialog(null, "Oops! No internet");
                System.exit(0);
            }
        }
        return koneksi;
    }
}
