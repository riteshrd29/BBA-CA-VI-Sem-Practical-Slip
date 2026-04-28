// Question: Write a java program in multithreading using Swing for Traffic signal. [25 M]
import javax.swing.*;
import java.awt.*;

public class Q2_ProgramName extends JPanel implements Runnable {
    private Thread redThread, yellowThread, greenThread;
    private Color currentLight = Color.RED;
    private int lightTimer = 0;
    
    public Q2_ProgramName() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 400));
        
        // Create and start traffic light threads
        redThread = new Thread(this, "Red-Light");
        yellowThread = new Thread(this, "Yellow-Light"); 
        greenThread = new Thread(this, "Green-Light");
        
        redThread.start();
        yellowThread.start();
        greenThread.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw traffic light box
        g.setColor(Color.GRAY);
        g.fillRect(100, 50, 100, 250);
        
        // Draw red light
        g.setColor(currentLight == Color.RED ? Color.RED : Color.DARK_GRAY);
        g.fillOval(125, 70, 50, 50);
        
        // Draw yellow light
        g.setColor(currentLight == Color.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
        g.fillOval(125, 140, 50, 50);
        
        // Draw green light
        g.setColor(currentLight == Color.GREEN ? Color.GREEN : Color.DARK_GRAY);
        g.fillOval(125, 210, 50, 50);
        
        // Display current light status
        g.setColor(Color.WHITE);
        g.drawString("Current Light: " + getLightName(), 80, 330);
        g.drawString("Timer: " + lightTimer + "s", 120, 350);
    }
    
    private String getLightName() {
        if (currentLight == Color.RED) return "RED";
        if (currentLight == Color.YELLOW) return "YELLOW";
        return "GREEN";
    }
    
    public void run() {
        String threadName = Thread.currentThread().getName();
        
        while (true) {
            try {
                if (threadName.equals("Red-Light")) {
                    synchronized (this) {
                        currentLight = Color.RED;
                        lightTimer = 5;
                        for (int i = 5; i >= 0; i--) {
                            lightTimer = i;
                            repaint();
                            Thread.sleep(1000);
                        }
                    }
                }
                else if (threadName.equals("Yellow-Light")) {
                    synchronized (this) {
                        currentLight = Color.YELLOW;
                        lightTimer = 2;
                        for (int i = 2; i >= 0; i--) {
                            lightTimer = i;
                            repaint();
                            Thread.sleep(1000);
                        }
                    }
                }
                else if (threadName.equals("Green-Light")) {
                    synchronized (this) {
                        currentLight = Color.GREEN;
                        lightTimer = 5;
                        for (int i = 5; i >= 0; i--) {
                            lightTimer = i;
                            repaint();
                            Thread.sleep(1000);
                        }
                    }
                }
                
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
    public void stop() {
        if (redThread != null) redThread.interrupt();
        if (yellowThread != null) yellowThread.interrupt();
        if (greenThread != null) greenThread.interrupt();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Signal Simulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            
            Q2_ProgramName trafficLight = new Q2_ProgramName();
            frame.add(trafficLight);
            
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            // Add window listener to stop threads when window closes
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    trafficLight.stop();
                }
            });
        });
    }
}
