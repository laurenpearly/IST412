package Authentication;

public class AuthController {

    /**
     * Constructor for Authentication Controller.
     */
    public AuthController() {

    }

    /**
     * Authenticates a user's input with the login info from Model.
     * @param userName User's input username.
     * @param userPassword User's input password.
     */
    public void authenticate(String userName, String userPassword) {
        System.out.println("Output from Authentication.Controller.authenticate(): username: " + userName +
                " password: " + userPassword);
    }
}
