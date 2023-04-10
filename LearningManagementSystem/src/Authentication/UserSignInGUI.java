package Authentication;

import Authentication.Model.Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserSignInGUI extends JFrame implements ActionListener {
    // GUI Components
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton, registerButton;
    private JProgressBar progressBar = new JProgressBar();
    private Timer timer;

    public UserSignInGUI() {
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
                progressBar.setValue(checkPasswordStrength(String.valueOf(passwordField.getPassword())));
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
            FileAuthenticator authenticator = new FileAuthenticator();
            if (authenticator.authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
        else if(e.getSource() == registerButton){
            String username = usernameTextField.getText();
            char[] password = passwordField.getPassword();
            String passwordString = new String(password);

            // Write the username and password to the users.txt file
            try {
                FileWriter fileWriter = new FileWriter("/src/Authentication/logins.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.newLine();
                bufferedWriter.write(username + ":" + passwordString);
                bufferedWriter.close();
                JOptionPane.showMessageDialog(this, "Your Account has been Registered Successfully.");
                progressBar.setValue(checkPasswordStrength(passwordString));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file.");
            }
        }
    }

    class FileAuthenticator {
        private static final String FILENAME = "src/Authentication/logins.txt";
    
        public boolean authenticate(String username, char[] password) {
            // Get the saved passwords from our logins file
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(new String(password))) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
    
    public int checkPasswordStrength(String password) {
        int complexity = 0;
        if (password.length() >= 8) {
            complexity++;
        }
        if (password.matches(".*[A-Z].*")) {
            complexity++;
        } 
        if (password.matches(".*[a-z].*")) {
            complexity++;
        }
        if (password.matches(".*[0-9].*")) {
            complexity++;
        }
        if (password.matches(".*[@#$%^&+=].*")) {
            complexity++;
        }
        return complexity;
    }
    

    public static void main(String[] args) {
        new UserSignInGUI();
    }
}