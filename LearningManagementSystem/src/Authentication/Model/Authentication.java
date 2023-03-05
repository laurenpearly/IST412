package Authentication.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {
    Scanner sc = new Scanner("userInfo.txt");
    ArrayList<String> users = new ArrayList<String>();
    String userName;
    String userPassword;

    /**
     * Constructs Authentication.
     * Builds the user ArrayList from a txt file for use in program.
     */
    public Authentication() {
        try{
        File userInfo = new File("D:\\IST412\\LearningManagementSystem\\src\\Authentication\\userInfo.txt");   
        Scanner sc = new Scanner(userInfo);
        
        while (sc.hasNextLine()){
            String accountInfo = sc.nextLine();
            String[] str = new String[2];
            str = accountInfo.split(", ");

            users.add(str[0]);  // userName (even numbers)
            users.add(str[1]);  // userPassword (odd numbers)

            str = null;         // Empties temp list
        }
        sc.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Authenticates a user at login.
     * @param users List of users and their IDs, Usernames, Passwords, First Names, and Last Names.
     */
    public void authenticate(ArrayList<String> users) {

    }
}
