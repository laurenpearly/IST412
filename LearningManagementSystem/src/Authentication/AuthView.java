package Authentication;

import Authentication.Model.Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AuthView extends JFrame implements ActionListener {
    // GUI Components
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton, registerButton;
    private JProgressBar progressBar;
    private Timer timer;

    //other objects
    Authentication auth;
    AuthController authCntl;

    public AuthView(AuthController authCtl) {
        this.authCntl = authCtl;
        progressBar = new JProgressBar();
        auth = new Authentication();
    }

    public void showGui() {
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        registerButton = new JButton("Register");

        setLayout(new GridLayout(4, 2, 5, 5));

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                progressBar.setValue(authCntl.checkPasswordStrength(String.valueOf(passwordField.getPassword())));
            }
        });
        timer.start();

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);
        add(registerButton);
        progressBar.setMaximum(5);
        add(progressBar);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        registerButton.addActionListener(this);

        setTitle("User Sign In");
        setSize(600, 300);
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
            if (authCntl.authenticate(username, password)) {
                authCntl.viewUser(username);
                //JOptionPane.showMessageDialog(this, "Login successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
        } else if(e.getSource() == registerButton){
            String username = usernameTextField.getText();
            char[] password = passwordField.getPassword();
            String passwordString = new String(password);

            // Write the username and password to the users.txt file
            try {
                authCntl.registerUser(username, passwordString);
                JOptionPane.showMessageDialog(this, "Your Account has been Registered Successfully.");
                progressBar.setValue(authCntl.checkPasswordStrength(passwordString));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file.");
            }
        }
    }

}