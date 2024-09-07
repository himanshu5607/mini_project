import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class SignUpForm11 extends JFrame {

    public SignUpForm11() {
        // Set up the frame
        setTitle("NinHash Sign Up");
        setSize(400, 500); // Increase size to accommodate new fields
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
        gbc.gridx = 0;

        // Heading label with "Sign Up"
        JLabel headingLabel = new JLabel("Sign Up", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setForeground(Color.WHITE); // White color for text
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(headingLabel, gbc);

        // Username label
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
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

        // Move to the next row for the password fields
        gbc.gridx = 0;
        gbc.gridy = 2;

        // Password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel, gbc);

        // Password text field with placeholder
        JPasswordField passwordText = new JPasswordField("Choose A Password");
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
                if (pwd.equals("Choose A Password")) {
                    passwordText.setText("");
                    passwordText.setForeground(Color.BLACK);
                    passwordText.setEchoChar('•'); // Set echo character to hide password
                }
            }

            public void focusLost(FocusEvent e) {
                String pwd = new String(passwordText.getPassword());
                if (pwd.isEmpty()) {
                    passwordText.setForeground(Color.GRAY);
                    passwordText.setText("Choose A Password");
                    passwordText.setEchoChar((char) 0); // Remove echo character for placeholder
                }
            }
        });

        // Move to the next row for the confirm password fields
        gbc.gridx = 0;
        gbc.gridy = 3;

        // Confirm Password label
        JLabel confirmPasswordLabel = new JLabel("Confirm");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        confirmPasswordLabel.setForeground(Color.WHITE);
        panel.add(confirmPasswordLabel, gbc);

        // Confirm Password text field with placeholder
        JPasswordField confirmPasswordText = new JPasswordField("Confirm Your Password");
        confirmPasswordText.setPreferredSize(new Dimension(200, 30));
        confirmPasswordText.setForeground(Color.GRAY); // Set the placeholder text color to gray
        confirmPasswordText.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Beautiful input box
        confirmPasswordText.setEchoChar((char) 0); // Display placeholder text, without the echo character
        gbc.gridx = 1;
        panel.add(confirmPasswordText, gbc);

        // Add focus listener to clear placeholder text when focused
        confirmPasswordText.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                String pwd = new String(confirmPasswordText.getPassword());
                if (pwd.equals("Confirm Your Password")) {
                    confirmPasswordText.setText("");
                    confirmPasswordText.setForeground(Color.BLACK);
                    confirmPasswordText.setEchoChar('•'); // Set echo character to hide password
                }
            }

            public void focusLost(FocusEvent e) {
                String pwd = new String(confirmPasswordText.getPassword());
                if (pwd.isEmpty()) {
                    confirmPasswordText.setForeground(Color.GRAY);
                    confirmPasswordText.setText("Confirm Your Password");
                    confirmPasswordText.setEchoChar((char) 0); // Remove echo character for placeholder
                }
            }
        });

        // Sign Up button with hover effect
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(70, 130, 180)); // Steel blue color for the button
        signUpButton.setForeground(Color.WHITE); // White text
        signUpButton.setFocusPainted(false); // Remove focus border
        signUpButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding for the button

        // Hover effect: change background color when mouse enters or exits the button area
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpButton.setBackground(new Color(100, 149, 237)); // Light blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpButton.setBackground(new Color(70, 130, 180)); // Revert to original color
            }
        });

        panel.add(signUpButton, gbc);

        // "Already have an account?" label and Login link
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false); // Make sure the background is transparent

        JLabel alreadyHaveAccountText = new JLabel("Already have an account? ");
        alreadyHaveAccountText.setFont(new Font("Arial", Font.PLAIN, 14));
        alreadyHaveAccountText.setForeground(Color.WHITE);

        JLabel loginLink = new JLabel("<html><u><font color='#1976D2'>Login</font></u></html>"); // Blue normal 700 with underline
        loginLink.setFont(new Font("Arial", Font.PLAIN, 14));
        loginLink.setForeground(new Color(25, 118, 210)); // Blue normal 700 color
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover

        // Add mouse listener to open NinHashLoginPage31 when clicked
        loginLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new NinHashLoginPage09().setVisible(true);
                dispose(); // Close the sign-up form
            }
        });

        loginPanel.add(alreadyHaveAccountText);
        loginPanel.add(loginLink);
        panel.add(loginPanel, gbc);

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpForm11().setVisible(true);
            }
        });
    }
}

