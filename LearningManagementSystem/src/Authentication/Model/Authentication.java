package Authentication.Model;

import javax.swing.*;
import java.io.*;

public class Authentication {

    private static final String FILENAME = "src/Authentication/logins.txt";

    //singleton object
    private static Authentication obj;

    public Authentication() {
        //don't put anything in here to force getInstance() to enforce this class as a singleton
    }

    //to enforce singleton
    public static Authentication getInstance()
    {
        return obj;
    }

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

    public void registerUser(String username, String password) throws IOException {
        FileWriter fileWriter = new FileWriter("/src/Authentication/logins.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.write(username + ":" + password);
        bufferedWriter.close();
    }

}
