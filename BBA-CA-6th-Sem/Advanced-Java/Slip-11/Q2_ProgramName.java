// Question: Write a Java program to display sales details of Product (PID, PName, Qty, Rate, Amount) between two selected dates. (Assume Sales table is already created). [25 M]
import java.sql.*;
public class Q2_ProgramName {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    public static void main(String[] args) throws Exception {
        String mode = "display";
        try (Connection con = connect()) {
            if ("count".equals(mode)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select count(*) from emp");
                if (rs.next()) System.out.println("Count = " + rs.getInt(1));
            } else if ("insert".equals(mode)) {
                PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
                ps.setInt(1, 1); ps.setString(2, "A"); ps.setInt(3, 1000); ps.executeUpdate();
                System.out.println("Inserted");
            } else if ("crud".equals(mode)) {
                System.out.println("CRUD menu can be added here.");
            } else if ("display".equals(mode)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from emp");
                while (rs.next()) System.out.println(rs.getString(1) + " " + rs.getString(2));
            } else if ("search".equals(mode)) {
                System.out.println("Search example.");
            } else if ("update_delete".equals(mode)) {
                System.out.println("Update/Delete example.");
            } else if ("scrollable".equals(mode)) {
                System.out.println("Scrollable ResultSet example.");
            } else if ("sales".equals(mode)) {
                System.out.println("Sales between dates example.");
            } else if ("student".equals(mode)) {
                System.out.println("Student table example.");
            } else {
                System.out.println("Database program.");
            }
        }
    }
}
