// Question: Write a Java program to accept details of students (rno, sname, per) at least 5 Records, store it into database and display details of student having highest percentage. (Use PreparedStatement Interface) [25 M]
import java.sql.*;
public class Q2_ProgramName {
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
            
            // Insert at least 5 student records using PreparedStatement
            String insertSQL = "INSERT INTO Student (rno, sname, per) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            
            Object[][] students = {
                {101, "Alice Johnson", 85.50},
                {102, "Bob Smith", 92.75},
                {103, "Charlie Brown", 78.25},
                {104, "Diana Prince", 95.00},
                {105, "Edward Norton", 88.50},
                {106, "Fiona Green", 91.25}
            };
            
            for (Object[] student : students) {
                ps.setInt(1, (Integer) student[0]);
                ps.setString(2, (String) student[1]);
                ps.setDouble(3, (Double) student[2]);
                ps.executeUpdate();
                System.out.println("Inserted student: " + student[0] + " - " + student[1] + " (" + student[2] + "%)");
            }
            
            // Display all students
            System.out.println("\n--- All Student Records ---");
            ResultSet rs = st.executeQuery("SELECT * FROM Student ORDER BY per DESC");
            while (rs.next()) {
                System.out.println("RNo: " + rs.getInt("rno") + 
                                 ", Name: " + rs.getString("sname") + 
                                 ", Percentage: " + rs.getDouble("per") + "%");
            }
            
            // Display student with highest percentage
            System.out.println("\n--- Student with Highest Percentage ---");
            ResultSet highestRs = st.executeQuery("SELECT * FROM Student WHERE per = (SELECT MAX(per) FROM Student)");
            if (highestRs.next()) {
                System.out.println("Top Student:");
                System.out.println("RNo: " + highestRs.getInt("rno"));
                System.out.println("Name: " + highestRs.getString("sname"));
                System.out.println("Percentage: " + highestRs.getDouble("per") + "%");
                System.out.println("Congratulations to " + highestRs.getString("sname") + " for achieving the highest percentage!");
            } else {
                System.out.println("No student records found.");
            }
            
            ps.close();
            st.close();
            rs.close();
            highestRs.close();
            System.out.println("\nProgram completed successfully!");
        }
    }
}
