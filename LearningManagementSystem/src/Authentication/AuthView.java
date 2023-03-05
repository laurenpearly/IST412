package Authentication;

public class AuthView {
    String userName;
    String userPassword;

    /**
     * Constructor for Authentication View.
     */
    public AuthView() {

    }

    /**
     * Displays a user's input with login info.
     * @param userName User's input username.
     * @param userPassword User's input password.
     */
    public void display(String userName, String userPassword) {
        System.out.println("Output from Authentication.AuthView(): " + "UserName: " + userName);
        System.out.println("Output from Authentication.AuthView(): " + "UserPassword: " + userPassword);
    }
}
