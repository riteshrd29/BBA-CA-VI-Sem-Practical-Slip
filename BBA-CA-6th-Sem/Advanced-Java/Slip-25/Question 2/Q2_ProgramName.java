// Question: Write a Java Program for following: Assume database is already created. [25 M]
import java.sql.*;
import java.util.Scanner;

public class Q2_ProgramName {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = connect()) {
            // Create Employee table if not exists
            Statement st = con.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" +
                                   "EmpID INT PRIMARY KEY, " +
                                   "EmpName VARCHAR(50), " +
                                   "Department VARCHAR(30), " +
                                   "Salary DECIMAL(10,2), " +
                                   "JoinDate DATE)";
            st.execute(createTableSQL);
            System.out.println("Employee table created/verified successfully.");
            
            // Insert sample data if table is empty
            ResultSet countRs = st.executeQuery("SELECT COUNT(*) FROM Employee");
            countRs.next();
            if (countRs.getInt(1) == 0) {
                System.out.println("Inserting sample employee data...");
                String insertSQL = "INSERT INTO Employee (EmpID, EmpName, Department, Salary, JoinDate) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertPs = con.prepareStatement(insertSQL);
                
                Object[][] employees = {
                    {1001, "John Smith", "IT", 75000.00, "2022-01-15"},
                    {1002, "Jane Johnson", "HR", 65000.00, "2021-03-20"},
                    {1003, "Mike Williams", "Finance", 80000.00, "2020-06-10"},
                    {1004, "Sarah Davis", "Marketing", 70000.00, "2022-09-05"},
                    {1005, "Robert Brown", "IT", 85000.00, "2019-11-12"}
                };
                
                for (Object[] emp : employees) {
                    insertPs.setInt(1, (Integer) emp[0]);
                    insertPs.setString(2, (String) emp[1]);
                    insertPs.setString(3, (String) emp[2]);
                    insertPs.setDouble(4, (Double) emp[3]);
                    insertPs.setDate(5, java.sql.Date.valueOf((String) emp[4]));
                    insertPs.executeUpdate();
                }
                insertPs.close();
                System.out.println("Sample data inserted successfully.");
            }
            countRs.close();
            
            // Interactive menu system
            while (true) {
                System.out.println("\n=== Employee Database Management System ===");
                System.out.println("1. Display All Employees");
                System.out.println("2. Add New Employee");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Search Employee by ID");
                System.out.println("6. Display Employees by Department");
                System.out.println("7. Calculate Average Salary by Department");
                System.out.println("8. Exit");
                System.out.print("Enter your choice (1-8): ");
                
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                
                switch (choice) {
                    case 1:
                        displayAllEmployees(con);
                        break;
                    case 2:
                        addEmployee(con, scanner);
                        break;
                    case 3:
                        updateEmployeeSalary(con, scanner);
                        break;
                    case 4:
                        deleteEmployee(con, scanner);
                        break;
                    case 5:
                        searchEmployee(con, scanner);
                        break;
                    case 6:
                        displayByDepartment(con, scanner);
                        break;
                    case 7:
                        calculateAverageSalary(con, scanner);
                        break;
                    case 8:
                        System.out.println("Exiting program. Goodbye!");
                        st.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1-8.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    private static void displayAllEmployees(Connection con) throws SQLException {
        System.out.println("\n--- All Employee Records ---");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Employee ORDER BY EmpID");
        
        while (rs.next()) {
            System.out.printf("ID: %d, Name: %s, Dept: %s, Salary: %.2f, JoinDate: %s\n",
                            rs.getInt("EmpID"), rs.getString("EmpName"), 
                            rs.getString("Department"), rs.getDouble("Salary"), 
                            rs.getDate("JoinDate"));
        }
        rs.close();
        st.close();
    }
    
    private static void addEmployee(Connection con, Scanner scanner) throws SQLException {
        try {
            System.out.print("Enter Employee ID: ");
            int empId = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Employee Name: ");
            String empName = scanner.nextLine();
            
            System.out.print("Enter Department: ");
            String dept = scanner.nextLine();
            
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter Join Date (YYYY-MM-DD): ");
            String joinDate = scanner.nextLine();
            
            String insertSQL = "INSERT INTO Employee (EmpID, EmpName, Department, Salary, JoinDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            ps.setInt(1, empId);
            ps.setString(2, empName);
            ps.setString(3, dept);
            ps.setDouble(4, salary);
            ps.setDate(5, java.sql.Date.valueOf(joinDate));
            
            int rows = ps.executeUpdate();
            ps.close();
            
            if (rows > 0) {
                System.out.println("Employee added successfully!");
            } else {
                System.out.println("Failed to add employee.");
            }
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }
    
    private static void updateEmployeeSalary(Connection con, Scanner scanner) throws SQLException {
        try {
            System.out.print("Enter Employee ID to update: ");
            int empId = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter New Salary: ");
            double newSalary = Double.parseDouble(scanner.nextLine());
            
            String updateSQL = "UPDATE Employee SET Salary = ? WHERE EmpID = ?";
            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            
            int rows = ps.executeUpdate();
            ps.close();
            
            if (rows > 0) {
                System.out.println("Salary updated successfully!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error updating salary: " + e.getMessage());
        }
    }
    
    private static void deleteEmployee(Connection con, Scanner scanner) throws SQLException {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int empId = Integer.parseInt(scanner.nextLine());
            
            String deleteSQL = "DELETE FROM Employee WHERE EmpID = ?";
            PreparedStatement ps = con.prepareStatement(deleteSQL);
            ps.setInt(1, empId);
            
            int rows = ps.executeUpdate();
            ps.close();
            
            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
    
    private static void searchEmployee(Connection con, Scanner scanner) throws SQLException {
        try {
            System.out.print("Enter Employee ID to search: ");
            int empId = Integer.parseInt(scanner.nextLine());
            
            String searchSQL = "SELECT * FROM Employee WHERE EmpID = ?";
            PreparedStatement ps = con.prepareStatement(searchSQL);
            ps.setInt(1, empId);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\n--- Employee Found ---");
                System.out.printf("ID: %d, Name: %s, Dept: %s, Salary: %.2f, JoinDate: %s\n",
                                rs.getInt("EmpID"), rs.getString("EmpName"), 
                                rs.getString("Department"), rs.getDouble("Salary"), 
                                rs.getDate("JoinDate"));
            } else {
                System.out.println("Employee not found.");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }
    }
    
    private static void displayByDepartment(Connection con, Scanner scanner) throws SQLException {
        System.out.print("Enter Department Name: ");
        String dept = scanner.nextLine();
        
        String searchSQL = "SELECT * FROM Employee WHERE Department = ? ORDER BY EmpID";
        PreparedStatement ps = con.prepareStatement(searchSQL);
        ps.setString(1, dept);
        
        ResultSet rs = ps.executeQuery();
        System.out.println("\n--- Employees in " + dept + " Department ---");
        boolean found = false;
        
        while (rs.next()) {
            found = true;
            System.out.printf("ID: %d, Name: %s, Salary: %.2f\n",
                            rs.getInt("EmpID"), rs.getString("EmpName"), rs.getDouble("Salary"));
        }
        
        if (!found) {
            System.out.println("No employees found in " + dept + " department.");
        }
        
        rs.close();
        ps.close();
    }
    
    private static void calculateAverageSalary(Connection con, Scanner scanner) throws SQLException {
        String avgSQL = "SELECT Department, AVG(Salary) as AvgSalary FROM Employee GROUP BY Department ORDER BY AvgSalary DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(avgSQL);
        
        System.out.println("\n--- Average Salary by Department ---");
        while (rs.next()) {
            System.out.printf("Department: %s, Average Salary: %.2f\n",
                            rs.getString("Department"), rs.getDouble("AvgSalary"));
        }
        
        rs.close();
        st.close();
    }
}
