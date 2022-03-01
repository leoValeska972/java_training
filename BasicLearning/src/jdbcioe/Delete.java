package jdbcioe;

import java.sql.*;

/**
 * <h2>Delete Class</h2>
 * <p>
 * Process for Displaying Delete
 * </p>
 * 
 * @author User
 *
 */
public class Delete {
    /**
     * <h2>main</h2>
     * <p>
     * Main Method
     * </p>
     *
     * @param args String
     * @return void
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jtest", "root", "Demoninsideme1412$");
            Statement stmt = con.createStatement();
            String del = "DELETE FROM testing WHERE id=2";
            stmt.execute(del);
            String sel = "SELECT * FROM testing";
            ResultSet rs = stmt.executeQuery(sel);
            while (rs.next())
                System.out.println("ID : " + rs.getInt("id") + "\nName : " + rs.getString("Name") + "\nEmail : "
                        + rs.getString("email") + "\n");
            con.close();
        } catch (Exception e) {
            System.out.println("Delete Error");
        }
    }
}
