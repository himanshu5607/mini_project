import javax.swing.*;
import java.awt.*;

public class ScanningPage extends JFrame {

    public ScanningPage() {
        // Set up the frame
        setTitle("NinHash - Scanning Hash");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Set a colorful background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set background gradient color
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(255, 105, 180); // Pink
                Color color2 = new Color(135, 206, 250); // Light Blue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Scanning label
        JLabel scanningLabel = new JLabel("Wait, we are scanning your hash...", SwingConstants.CENTER);
        scanningLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scanningLabel.setForeground(Color.WHITE); // White color for text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(scanningLabel, gbc);

        // Buffering animation (Using a JProgressBar to simulate loading)
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Set the progress bar to indeterminate mode
        progressBar.setPreferredSize(new Dimension(300, 30));
        progressBar.setBackground(new Color(135, 206, 250)); // Light blue background
        progressBar.setForeground(new Color(255, 105, 180)); // Pink progress indicator
        gbc.gridy = 1;
        panel.add(progressBar, gbc);

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScanningPage().setVisible(true);
            }
        });
    }
}

