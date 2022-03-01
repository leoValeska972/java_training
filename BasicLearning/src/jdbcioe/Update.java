package jdbcioe;

import java.sql.*;

/**
 * <h2>Update Class</h2>
 * <p>
 * Process for Displaying Update
 * </p>
 * 
 * @author User
 *
 */
public class Update {
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
            String upd = "UPDATE testing SET name='Steve Roger' WHERE id=2";
            stmt.execute(upd);
            String sel = "SELECT * FROM testing";
            ResultSet rs = stmt.executeQuery(sel);
            while (rs.next())
                System.out.println("ID : " + rs.getInt("id") + "\nName : " + rs.getString("Name") + "\nEmail : "
                        + rs.getString("email") + "\n");
            con.close();
        } catch (Exception e) {
            System.out.println("Update Error");
        }
    }
}
