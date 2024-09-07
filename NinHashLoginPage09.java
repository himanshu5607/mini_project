import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NinHashLoginPage09 extends JFrame {

    public NinHashLoginPage09() {
        // Set up the frame
        setTitle("NinHash Login");
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Heading label with "Welcome to NinHash"
        JLabel headingLabel = new JLabel("Welcome to NinHash", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setForeground(Color.WHITE); // White color for text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headingLabel, gbc);

        // Username label
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Set gridwidth to 1 to place the label next to the text field
        panel.add(userLabel, gbc);

        // Username text field with placeholder
        JTextField userText = new JTextField("Username");
        userText.setPreferredSize(new Dimension(200, 30));
        userText.setForeground(Color.GRAY); // Set the placeholder text color to gray
        userText.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Beautiful input box
        gbc.gridx = 1;
        panel.add(userText, gbc);

        // Add focus listener to clear placeholder text when focused
        userText.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (userText.getText().equals("Username")) {
                    userText.setText("");
                    userText.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (userText.getText().isEmpty()) {
                    userText.setForeground(Color.GRAY);
                    userText.setText("Username");
                }
            }
        });

        // Password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        // Password text field with placeholder
        JPasswordField passwordText = new JPasswordField("Enter Your Password");
        passwordText.setPreferredSize(new Dimension(200, 30));
        passwordText.setForeground(Color.GRAY); // Set the placeholder text color to gray
        passwordText.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Beautiful input box
        passwordText.setEchoChar((char) 0); // Display placeholder text, without the echo character
        gbc.gridx = 1;
        panel.add(passwordText, gbc);

        // Add focus listener to clear placeholder text when focused
        passwordText.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                String pwd = new String(passwordText.getPassword());
                if (pwd.equals("Enter Your Password")) {
                    passwordText.setText("");
                    passwordText.setForeground(Color.BLACK);
                    passwordText.setEchoChar('•'); // Set echo character to hide password
                }
            }

            public void focusLost(FocusEvent e) {
                String pwd = new String(passwordText.getPassword());
                if (pwd.isEmpty()) {
                    passwordText.setForeground(Color.GRAY);
                    passwordText.setText("Enter Your Password");
                    passwordText.setEchoChar((char) 0); // Remove echo character for placeholder
                }
            }
        });

        // Login button with hover effect
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70, 130, 180)); // Steel blue color for the button
        loginButton.setForeground(Color.WHITE); // White text
        loginButton.setFocusPainted(false); // Remove focus border
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding for the button

        // Hover effect: change background color when mouse enters or exits the button area
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(100, 149, 237)); // Light blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(70, 130, 180)); // Revert to original color
            }
        });

        panel.add(loginButton, gbc);

        // "Don't have an account?" label and Signup link
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JPanel signUpPanel = new JPanel();
        signUpPanel.setOpaque(false); // Make sure the background is transparent

        JLabel signUpText = new JLabel("Don't have an account? ");
        signUpText.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpText.setForeground(Color.WHITE);

        JLabel signUpLink = new JLabel("<html><u><font color='#1976D2'>Signup</font></u></html>"); // Blue normal 700 with underline
        signUpLink.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpLink.setForeground(new Color(25, 118, 210)); // Blue normal 700 color
        signUpLink.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover

        // Add mouse listener to open SignUpForm when clicked
        signUpLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignUpForm11().setVisible(true);
                dispose(); // Close the login form
            }
        });

        signUpPanel.add(signUpText);
        signUpPanel.add(signUpLink);
        panel.add(signUpPanel, gbc);

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NinHashLoginPage09().setVisible(true);
            }
        });
    }
}

