import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/ssmbuild";
        Connection con = null;
        try
        {
            Class.forName(driver);
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.out.println("Connect Successfull.");
            System.out.println("Cant't load Driver");
        }
        try
        {
            con= DriverManager.getConnection(URL,"root","cjc89684550");
            System.out.println("Connect Successfull.");
        }
        catch(Exception e)
        {
            System.out.println("Connect fail:" + e.getMessage());
        }
    }
}
