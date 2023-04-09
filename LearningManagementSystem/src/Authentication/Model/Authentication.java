package Authentication.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {

    //object for making singleton
    private static Authentication obj;
    Scanner sc = new Scanner("userInfo.txt");
    ArrayList<String> users = new ArrayList<String>();
    String userName;
    String userPassword;

    /**
     * Constructs Authentication.
     * Builds the user ArrayList from a txt file for use in program.
     */
    public Authentication() {
        //don't put anything in here to force getInstance() to enforce this class as a singleton
    }

    //to enforce singleton
    public static Authentication getInstance()
    {
        return obj;
    }

    public void authentication() {
        try{
            File userInfo = new File("userInfo.txt");
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
    public void authenticate(ArrayList<String> users, String userName, String userPaswword) {
        String temp = "";
        boolean done = false;

        while(!done)
        {
            System.out.println("Please enter your username: ");
            userName = sc.nextLine();
            System.out.println("Please enter your password: ");
            userPassword = sc.nextLine();

            for (int i = 0; i < users.size();) {
                temp = users.get(i);

                if (temp.equals(userName) && i % 2 == 0) {          // If the username is correct and an even number (all usernames are even numbers)
                    if(users.get(i + 1).equals(userPassword)) {     // The userPassword for the userName is the next element in the arrayList
                        System.out.println("Access granted.");
                        done = true;
                    }
                    else {
                        break;                                      // Goes back to entering the userName and userPassword
                    }
                }
                else {
                    i++;                                            // Continues searching arrayList for the userName
                }
            }

            System.out.println("The username or password entered was incorrect.");
        }
    }
}
