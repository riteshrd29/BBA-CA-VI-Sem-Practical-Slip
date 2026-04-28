// Question: Write a Java Program to display all the employee names whose initial character of a name is 'A'. [15 M]
import java.sql.*;
public class Q1_ProgramName {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    public static void main(String[] args) throws Exception {
        try (Connection con = connect()) {
            // Create Emp table
            Statement st = con.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Emp (" +
                                   "ENo INT PRIMARY KEY, " +
                                   "EName VARCHAR(50), " +
                                   "Salary DECIMAL(10,2))";
            st.execute(createTableSQL);
            System.out.println("Emp table created successfully.");
            
            // Clear existing data for fresh run
            st.execute("DELETE FROM Emp");
            
            // Insert sample employee records
            String insertSQL = "INSERT INTO Emp (ENo, EName, Salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            
            Object[][] employees = {
                {101, "Alice Johnson", 50000.00},
                {102, "Bob Smith", 60000.00},
                {103, "Andrew Williams", 45000.00},
                {104, "Sarah Anderson", 55000.00},
                {105, "Robert Brown", 65000.00},
                {106, "Amanda Davis", 48000.00},
                {107, "Michael Wilson", 52000.00},
                {108, "Anthony Martinez", 58000.00}
            };
            
            for (Object[] emp : employees) {
                ps.setInt(1, (Integer) emp[0]);
                ps.setString(2, (String) emp[1]);
                ps.setDouble(3, (Double) emp[2]);
                ps.executeUpdate();
            }
            ps.close();
            
            // Display all employees
            System.out.println("\n--- All Employee Records ---");
            ResultSet allRs = st.executeQuery("SELECT * FROM Emp ORDER BY ENo");
            while (allRs.next()) {
                System.out.println("ENo: " + allRs.getInt("ENo") + 
                                 ", Name: " + allRs.getString("EName") + 
                                 ", Salary: " + allRs.getDouble("Salary"));
            }
            allRs.close();
            
            // Display employees whose name starts with 'A'
            System.out.println("\n--- Employees whose names start with 'A' ---");
            ResultSet filterRs = st.executeQuery("SELECT * FROM Emp WHERE EName LIKE 'A%' ORDER BY ENo");
            boolean found = false;
            while (filterRs.next()) {
                found = true;
                System.out.println("ENo: " + filterRs.getInt("ENo") + 
                                 ", Name: " + filterRs.getString("EName") + 
                                 ", Salary: " + filterRs.getDouble("Salary"));
            }
            filterRs.close();
            
            if (!found) {
                System.out.println("No employees found whose names start with 'A'.");
            } else {
                System.out.println("\nFound employees whose names start with 'A'!");
            }
            
            st.close();
            System.out.println("\nProgram completed successfully!");
        }
    }
}
