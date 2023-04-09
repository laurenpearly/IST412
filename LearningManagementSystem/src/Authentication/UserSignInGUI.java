package Authentication;

import Authentication.Model.Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSignInGUI extends JFrame implements ActionListener {
    // GUI Components
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public UserSignInGUI() {
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        setLayout(new GridLayout(3, 2, 5, 5));

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setTitle("User Sign In");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ActionListener interface method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameTextField.getText();
            char[] password = passwordField.getPassword();
            // validate passwords
            JOptionPane.showMessageDialog(this, "Login successful.");
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new UserSignInGUI();
    }
}
