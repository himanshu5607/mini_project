import java.awt.*;
import javax.swing.*;

public class ThreeColumnDashboard77 extends JFrame {

    public ThreeColumnDashboard77() {
        // Set up the frame
        setTitle("NinHash Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create a custom JPanel with a pink-light blue gradient background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Using a pink-light blue gradient background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(255, 105, 180); // Pink
                Color color2 = new Color(135, 206, 250); // Light Blue
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBounds(0, 0, 800, 600);
        backgroundPanel.setLayout(null);

        // Add the three columns
        addFirstColumn(backgroundPanel);
        addSecondColumn(backgroundPanel);
        addThirdColumn(backgroundPanel);

        // Add panel to the frame
        add(backgroundPanel);

        // Set frame visibility
        setVisible(true);
    }

    private void addFirstColumn(JPanel panel) {
        JPanel firstColumn = new JPanel();
        firstColumn.setBounds(50, 100, 200, 400); // X, Y, Width, Height
        firstColumn.setBackground(new Color(255, 255, 255, 50)); // Transparent White
        firstColumn.setLayout(new BoxLayout(firstColumn, BoxLayout.Y_AXIS));

        // Add components centered in the column
        firstColumn.add(Box.createRigidArea(new Dimension(0, 50))); // Spacer to align with FAQ

        // Add profile photo symbol (ImageIcon)
        JLabel profilePhotoLabel = new JLabel();
        ImageIcon profileIcon = loadImageIcon("src/images/profile.png", 100, 100); // Adjust the path
        if (profileIcon != null) {
            profilePhotoLabel.setIcon(profileIcon);
        } else {
            profilePhotoLabel.setText("Profile Icon Missing");
        }
        profilePhotoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstColumn.add(profilePhotoLabel);

        firstColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Add User Profile label
        JLabel userProfileLabel = new JLabel("User Profile");
        userProfileLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userProfileLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userProfileLabel.setForeground(Color.WHITE);
        firstColumn.add(userProfileLabel);

        firstColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Add user login time label
        JLabel loginTimeLabel = new JLabel("Last Login: 12:30 PM");
        loginTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTimeLabel.setForeground(Color.WHITE);
        firstColumn.add(loginTimeLabel);

        firstColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Add logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setMaximumSize(new Dimension(100, 30));
        logoutButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        firstColumn.add(logoutButton);

        panel.add(firstColumn);
    }

    private void addSecondColumn(JPanel panel) {
        JPanel secondColumn = new JPanel();
        secondColumn.setBounds(300, 100, 200, 400); // X, Y, Width, Height
        secondColumn.setBackground(new Color(255, 255, 255, 50)); // Transparent White
        secondColumn.setLayout(new BoxLayout(secondColumn, BoxLayout.Y_AXIS));

        // Add components centered in the column
        secondColumn.add(Box.createRigidArea(new Dimension(0, 50))); // Spacer to align with FAQ

        // Add Start Password Tracking section
        JLabel startTrackingHeading = new JLabel("Start Password Tracking");
        startTrackingHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        startTrackingHeading.setFont(new Font("Arial", Font.BOLD, 14));
        startTrackingHeading.setForeground(Color.WHITE);
        secondColumn.add(startTrackingHeading);

        secondColumn.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        JButton startTrackingButton = new JButton("Start Tracking");
        startTrackingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startTrackingButton.setMaximumSize(new Dimension(150, 30));
        startTrackingButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        startTrackingButton.setForeground(Color.WHITE);
        startTrackingButton.setFocusPainted(false);
        startTrackingButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        secondColumn.add(startTrackingButton);

        secondColumn.add(Box.createRigidArea(new Dimension(0, 30))); // Spacer

        // Add Password Storing Info section
        JLabel passwordInfoHeading = new JLabel("Password Storing Info");
        passwordInfoHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordInfoHeading.setFont(new Font("Arial", Font.BOLD, 14));
        passwordInfoHeading.setForeground(Color.WHITE);
        secondColumn.add(passwordInfoHeading);

        secondColumn.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        JButton passwordInfoButton = new JButton("Click for Information");
        passwordInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordInfoButton.setMaximumSize(new Dimension(150, 30));
        passwordInfoButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        passwordInfoButton.setForeground(Color.WHITE);
        passwordInfoButton.setFocusPainted(false);
        passwordInfoButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        secondColumn.add(passwordInfoButton);

        panel.add(secondColumn);
    }

    private void addThirdColumn(JPanel panel) {
        JPanel thirdColumn = new JPanel();
        thirdColumn.setBounds(550, 100, 200, 400); // X, Y, Width, Height
        thirdColumn.setBackground(new Color(255, 255, 255, 50)); // Transparent White
        thirdColumn.setLayout(new BoxLayout(thirdColumn, BoxLayout.Y_AXIS));

        // Add components centered in the column
        thirdColumn.add(Box.createRigidArea(new Dimension(0, 50))); // Spacer

        JButton faqButton = new JButton("FAQ");
        faqButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        faqButton.setMaximumSize(new Dimension(150, 30));
        faqButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        faqButton.setForeground(Color.WHITE);
        faqButton.setFocusPainted(false);
        faqButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        thirdColumn.add(faqButton);

        thirdColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        JButton guideButton = new JButton("Guide");
        guideButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guideButton.setMaximumSize(new Dimension(150, 30));
        guideButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        guideButton.setForeground(Color.WHITE);
        guideButton.setFocusPainted(false);
        guideButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        thirdColumn.add(guideButton);

        thirdColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        JButton contactButton = new JButton("Contact Us");
        contactButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contactButton.setMaximumSize(new Dimension(150, 30));
        contactButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        contactButton.setForeground(Color.WHITE);
        contactButton.setFocusPainted(false);
        contactButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        thirdColumn.add(contactButton);

        thirdColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        JButton feedbackButton = new JButton("Feedback");
        feedbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackButton.setMaximumSize(new Dimension(150, 30));
        feedbackButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        feedbackButton.setForeground(Color.WHITE);
        feedbackButton.setFocusPainted(false);
        feedbackButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        thirdColumn.add(feedbackButton);

        thirdColumn.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        JButton aboutButton = new JButton("About");
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setMaximumSize(new Dimension(150, 30));
        aboutButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setFocusPainted(false);
        aboutButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        thirdColumn.add(aboutButton);

        panel.add(thirdColumn);
    }

    // Helper method to load ImageIcon with error handling
    private ImageIcon loadImageIcon(String path, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (Exception e) {
            System.out.println("Image not found: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ThreeColumnDashboard77::new);
    }
}
