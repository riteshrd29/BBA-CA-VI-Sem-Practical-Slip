// Question: Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table with attributes (TID, TName, Salary, Subject) is already created. [25 M]
import javax.swing.*;
import java.awt.*;
import java.time.*;
public class Q2_ProgramName extends JFrame {
    int x = 0, dir = 1;
    Timer timer;
    String mode = "scroll_text";
    public Q2_ProgramName() {
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        if ("digital_watch".equals(mode)) {
            JLabel l = new JLabel();
            l.setFont(new Font("Arial", Font.BOLD, 24));
            add(l);
            timer = new Timer(1000, e -> l.setText(LocalTime.now().toString()));
            timer.start();
        } else {
            timer = new Timer(50, e -> { x += 5 * dir; if (x > 380 || x < 0) dir *= -1; repaint(); });
            timer.start();
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        if ("scroll_text".equals(mode)) g.drawString("Scrolling Text", x, 100);
        else if ("blinking_image".equals(mode)) g.drawString((System.currentTimeMillis() / 500) % 2 == 0 ? "Blink" : "", 200, 100);
        else if ("traffic_signal".equals(mode)) { g.setColor(Color.RED); g.fillOval(200, 60, 40, 40); g.setColor(Color.YELLOW); g.fillOval(200, 110, 40, 40); g.setColor(Color.GREEN); g.fillOval(200, 160, 40, 40); }
        else if ("moving_car".equals(mode)) { g.fillRect(x, 150, 80, 30); }
        else if ("flag".equals(mode)) { g.setColor(Color.BLUE); g.fillRect(70, 60, 100, 60); g.setColor(Color.WHITE); g.fillRect(70, 120, 100, 60); g.setColor(Color.GREEN); g.fillRect(70, 180, 100, 60); }
        else if ("bouncing_ball".equals(mode)) { g.setColor(Color.ORANGE); g.fillOval(x, 120, 40, 40); }
        else if ("temple".equals(mode)) { g.drawRect(180, 120, 120, 80); g.drawLine(160, 120, 240, 70); g.drawLine(240, 70, 320, 120); }
        else if ("jtable".equals(mode)) { String[][] data = { {"101","A"}, {"102","B"} }; String[] cols = {"ID","Name"}; JTable t = new JTable(data, cols); t.setBounds(50, 80, 200, 60); add(t); }
    }
    public static void main(String[] a) { new Q2_ProgramName(); }
}
