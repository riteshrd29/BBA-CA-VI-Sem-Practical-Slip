// Question: Write a Java Program to create a Emp (ENo, EName, Sal) table and insert record into it. (Use PreparedStatement Interface) [15 M]
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
                                   "Sal DECIMAL(10,2))";
            st.execute(createTableSQL);
            System.out.println("Emp table created successfully.");
            
            // Insert records using PreparedStatement
            String insertSQL = "INSERT INTO Emp (ENo, EName, Sal) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSQL);
            
            // Insert multiple records
            Object[][] employees = {
                {101, "John Smith", 50000.00},
                {102, "Jane Doe", 60000.00},
                {103, "Mike Johnson", 45000.00},
                {104, "Sarah Williams", 55000.00},
                {105, "Robert Brown", 65000.00}
            };
            
            for (Object[] emp : employees) {
                ps.setInt(1, (Integer) emp[0]);
                ps.setString(2, (String) emp[1]);
                ps.setDouble(3, (Double) emp[2]);
                ps.executeUpdate();
                System.out.println("Inserted employee: " + emp[0] + " - " + emp[1]);
            }
            
            // Display all records
            System.out.println("\n--- Employee Records ---");
            ResultSet rs = st.executeQuery("SELECT * FROM Emp");
            while (rs.next()) {
                System.out.println("ENo: " + rs.getInt("ENo") + 
                                 ", EName: " + rs.getString("EName") + 
                                 ", Sal: " + rs.getDouble("Sal"));
            }
            
            ps.close();
            st.close();
            System.out.println("\nProgram completed successfully!");
        }
    }
}
