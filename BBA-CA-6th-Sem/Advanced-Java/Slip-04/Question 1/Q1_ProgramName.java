// Question: Write a Java Program to delete details of students whose initial character of their name is 'S'. [15 M]
import java.sql.*;
public class Q1_ProgramName {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    public static void main(String[] args) throws Exception {
        try (Connection con = connect()) {
            // Create Student table
            Statement st = con.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Student (" +
                                   "rno INT PRIMARY KEY, " +
                                   "sname VARCHAR(50), " +
                                   "per DECIMAL(5,2))";
            st.execute(createTableSQL);
            System.out.println("Student table created successfully.");
            
            // Clear existing data for fresh run
            st.execute("DELETE FROM Student");
            
            // Insert sample student records
            String insertSQL = "INSERT INTO Student (rno, sname, per) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            
            Object[][] students = {
                {101, "Alice Johnson", 85.50},
                {102, "Bob Smith", 92.75},
                {103, "Sarah Williams", 78.25},
                {104, "Diana Prince", 95.00},
                {105, "Steven Brown", 88.50},
                {106, "Fiona Green", 91.25},
                {107, "Susan Davis", 87.00},
                {108, "Michael Wilson", 89.75}
            };
            
            for (Object[] student : students) {
                ps.setInt(1, (Integer) student[0]);
                ps.setString(2, (String) student[1]);
                ps.setDouble(3, (Double) student[2]);
                ps.executeUpdate();
            }
            ps.close();
            
            // Display all students before deletion
            System.out.println("\n--- All Student Records Before Deletion ---");
            ResultSet beforeRs = st.executeQuery("SELECT * FROM Student ORDER BY rno");
            while (beforeRs.next()) {
                System.out.println("RNo: " + beforeRs.getInt("rno") + 
                                 ", Name: " + beforeRs.getString("sname") + 
                                 ", Percentage: " + beforeRs.getDouble("per") + "%");
            }
            beforeRs.close();
            
            // Find students whose name starts with 'S'
            ResultSet findRs = st.executeQuery("SELECT * FROM Student WHERE sname LIKE 'S%'");
            System.out.println("\n--- Students to be Deleted (names starting with 'S') ---");
            while (findRs.next()) {
                System.out.println("RNo: " + findRs.getInt("rno") + 
                                 ", Name: " + findRs.getString("sname"));
            }
            findRs.close();
            
            // Delete students whose name starts with 'S' using PreparedStatement
            String deleteSQL = "DELETE FROM Student WHERE sname LIKE 'S%'";
            PreparedStatement deletePs = con.prepareStatement(deleteSQL);
            int rowsDeleted = deletePs.executeUpdate();
            deletePs.close();
            
            System.out.println("\nSuccessfully deleted " + rowsDeleted + " student(s) whose name starts with 'S'.");
            
            // Display all students after deletion
            System.out.println("\n--- Student Records After Deletion ---");
            ResultSet afterRs = st.executeQuery("SELECT * FROM Student ORDER BY rno");
            while (afterRs.next()) {
                System.out.println("RNo: " + afterRs.getInt("rno") + 
                                 ", Name: " + afterRs.getString("sname") + 
                                 ", Percentage: " + afterRs.getDouble("per") + "%");
            }
            afterRs.close();
            
            st.close();
            System.out.println("\nProgram completed successfully!");
        }
    }
}
