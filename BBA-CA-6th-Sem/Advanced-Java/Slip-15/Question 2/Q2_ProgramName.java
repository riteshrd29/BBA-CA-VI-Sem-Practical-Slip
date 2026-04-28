// Question: Write a Java program to accept details of Student (RNo, SName, Per, Gender, Class) and store into the database. (Use appropriate Swing Components and PreparedStatement Interface). [25 M]
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q2_ProgramName extends JFrame {
    static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    
    private JTextField txtRNo, txtSName, txtPer, txtClass;
    private JRadioButton rbMale, rbFemale;
    private JButton btnInsert, btnDisplay, btnClear;
    private JTextArea taDisplay;
    
    public Q2_ProgramName() {
        setTitle("Student Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        
        inputPanel.add(new JLabel("Roll Number:"));
        txtRNo = new JTextField();
        inputPanel.add(txtRNo);
        
        inputPanel.add(new JLabel("Student Name:"));
        txtSName = new JTextField();
        inputPanel.add(txtSName);
        
        inputPanel.add(new JLabel("Percentage:"));
        txtPer = new JTextField();
        inputPanel.add(txtPer);
        
        inputPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        inputPanel.add(genderPanel);
        
        inputPanel.add(new JLabel("Class:"));
        txtClass = new JTextField();
        inputPanel.add(txtClass);
        
        // Button Panel
        JPanel buttonPanel = new JPanel();
        btnInsert = new JButton("Insert");
        btnDisplay = new JButton("Display All");
        btnClear = new JButton("Clear");
        
        btnInsert.addActionListener(e -> insertStudent());
        btnDisplay.addActionListener(e -> displayStudents());
        btnClear.addActionListener(e -> clearFields());
        
        buttonPanel.add(btnInsert);
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);
        
        // Display Area
        taDisplay = new JTextArea(10, 40);
        taDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taDisplay);
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void insertStudent() {
        try {
            int rno = Integer.parseInt(txtRNo.getText());
            String sname = txtSName.getText();
            double per = Double.parseDouble(txtPer.getText());
            String gender = rbMale.isSelected() ? "Male" : "Female";
            String className = txtClass.getText();
            
            try (Connection con = connect()) {
                // Create Student table if not exists
                Statement st = con.createStatement();
                st.execute("CREATE TABLE IF NOT EXISTS Student (" +
                          "RNo INT PRIMARY KEY, " +
                          "SName VARCHAR(50), " +
                          "Per DECIMAL(5,2), " +
                          "Gender VARCHAR(10), " +
                          "Class VARCHAR(20))");
                
                // Insert student record
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Student (RNo, SName, Per, Gender, Class) VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, rno);
                ps.setString(2, sname);
                ps.setDouble(3, per);
                ps.setString(4, gender);
                ps.setString(5, className);
                
                ps.executeUpdate();
                ps.close();
                st.close();
                
                JOptionPane.showMessageDialog(this, "Student record inserted successfully!");
                clearFields();
                displayStudents();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    private void displayStudents() {
        try (Connection con = connect()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student ORDER BY RNo");
            
            StringBuilder sb = new StringBuilder();
            sb.append("Roll No\tName\t\tPercentage\tGender\tClass\n");
            sb.append("------------------------------------------------------------\n");
            
            while (rs.next()) {
                sb.append(rs.getInt("RNo")).append("\t")
                  .append(rs.getString("SName")).append("\t\t")
                  .append(rs.getDouble("Per")).append("\t\t")
                  .append(rs.getString("Gender")).append("\t")
                  .append(rs.getString("Class")).append("\n");
            }
            
            taDisplay.setText(sb.toString());
            rs.close();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error displaying students: " + ex.getMessage());
        }
    }
    
    private void clearFields() {
        txtRNo.setText("");
        txtSName.setText("");
        txtPer.setText("");
        txtClass.setText("");
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Q2_ProgramName().setVisible(true);
        });
    }
}
