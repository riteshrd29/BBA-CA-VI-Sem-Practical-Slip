// Question: Write a JDBC program to delete the details of given employee (ENo EName Salary). Accept employee ID through command line. [15 M]
import java.sql.*;
public class Q1_ProgramName {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    public static void main(String[] args) throws Exception {
        // Check if employee ID is provided as command line argument
        if (args.length == 0) {
            System.out.println("Usage: java Q1_ProgramName <Employee_ID>");
            System.out.println("Example: java Q1_ProgramName 101");
            return;
        }
        
        int employeeIdToDelete;
        try {
            employeeIdToDelete = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Employee ID must be a valid integer.");
            return;
        }
        
        try (Connection con = connect()) {
            // Create Emp table if not exists
            Statement st = con.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Emp (" +
                                   "ENo INT PRIMARY KEY, " +
                                   "EName VARCHAR(50), " +
                                   "Salary DECIMAL(10,2))";
            st.execute(createTableSQL);
            
            // Insert sample data if table is empty
            ResultSet countRs = st.executeQuery("SELECT COUNT(*) FROM Emp");
            countRs.next();
            if (countRs.getInt(1) == 0) {
                System.out.println("Inserting sample employee data...");
                String insertSQL = "INSERT INTO Emp (ENo, EName, Salary) VALUES (?, ?, ?)";
                PreparedStatement insertPs = con.prepareStatement(insertSQL);
                
                Object[][] employees = {
                    {101, "John Smith", 50000.00},
                    {102, "Jane Doe", 60000.00},
                    {103, "Mike Johnson", 45000.00},
                    {104, "Sarah Williams", 55000.00},
                    {105, "Robert Brown", 65000.00}
                };
                
                for (Object[] emp : employees) {
                    insertPs.setInt(1, (Integer) emp[0]);
                    insertPs.setString(2, (String) emp[1]);
                    insertPs.setDouble(3, (Double) emp[2]);
                    insertPs.executeUpdate();
                }
                insertPs.close();
                System.out.println("Sample data inserted.");
            }
            countRs.close();
            
            // Display all employees before deletion
            System.out.println("\n--- Employee Records Before Deletion ---");
            ResultSet beforeRs = st.executeQuery("SELECT * FROM Emp ORDER BY ENo");
            boolean employeeExists = false;
            while (beforeRs.next()) {
                System.out.println("ENo: " + beforeRs.getInt("ENo") + 
                                 ", EName: " + beforeRs.getString("EName") + 
                                 ", Salary: " + beforeRs.getDouble("Salary"));
                if (beforeRs.getInt("ENo") == employeeIdToDelete) {
                    employeeExists = true;
                }
            }
            beforeRs.close();
            
            if (!employeeExists) {
                System.out.println("\nEmployee with ID " + employeeIdToDelete + " not found!");
                return;
            }
            
            // Delete the specified employee using PreparedStatement
            String deleteSQL = "DELETE FROM Emp WHERE ENo = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteSQL);
            deletePs.setInt(1, employeeIdToDelete);
            
            int rowsAffected = deletePs.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("\nSuccessfully deleted employee with ID: " + employeeIdToDelete);
                
                // Display all employees after deletion
                System.out.println("\n--- Employee Records After Deletion ---");
                ResultSet afterRs = st.executeQuery("SELECT * FROM Emp ORDER BY ENo");
                while (afterRs.next()) {
                    System.out.println("ENo: " + afterRs.getInt("ENo") + 
                                     ", EName: " + afterRs.getString("EName") + 
                                     ", Salary: " + afterRs.getDouble("Salary"));
                }
                afterRs.close();
            } else {
                System.out.println("\nFailed to delete employee with ID: " + employeeIdToDelete);
            }
            
            deletePs.close();
            st.close();
            System.out.println("\nProgram completed successfully!");
        }
    }
}
