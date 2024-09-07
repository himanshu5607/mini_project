import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HashValuePage extends JFrame {

    public HashValuePage() {
        // Set up the frame
        setTitle("NinHash - Enter Hash Value");
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
        gbc.insets = new Insets(10, 10, 5, 10); // Adjust padding as needed
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Heading label
        JLabel headingLabel = new JLabel("Enter Your Hash Value", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setForeground(Color.WHITE); // White color for text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headingLabel, gbc);

        // Hash value label (White and Bold)
        JLabel hashLabel = new JLabel("Hash Value");
        hashLabel.setFont(new Font("Arial", Font.BOLD, 16));
        hashLabel.setForeground(Color.WHITE); // White color for the label
        gbc.gridy = 1;
        panel.add(hashLabel, gbc);

        // Hash value text field with placeholder "hash_value"
        JTextField hashText = new JTextField("hash_value");
        hashText.setPreferredSize(new Dimension(200, 30));
        hashText.setForeground(Color.GRAY); // Set the placeholder text color to gray
        hashText.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Beautiful input box
        gbc.gridy = 2;
        panel.add(hashText, gbc);

        // Add focus listener to clear placeholder text when focused
        hashText.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (hashText.getText().equals("hash_value")) {
                    hashText.setText("");
                    hashText.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (hashText.getText().isEmpty()) {
                    hashText.setForeground(Color.GRAY);
                    hashText.setText("hash_value");
                }
            }
        });

        // Scan button with hover effect
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton scanButton = new JButton("Scan");
        scanButton.setBackground(new Color(70, 130, 180)); // Steel blue color for the button
        scanButton.setForeground(Color.WHITE); // White text
        scanButton.setFocusPainted(false); // Remove focus border
        scanButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding for the button

        // Hover effect: change background color when mouse enters or exits the button area
        scanButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                scanButton.setBackground(new Color(100, 149, 237)); // Light blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                scanButton.setBackground(new Color(70, 130, 180)); // Revert to original color
            }
        });

        panel.add(scanButton, gbc);

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HashValuePage().setVisible(true);
            }
        });
    }
}

