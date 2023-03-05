package Authentication;

    import Authentication.Model.Authentication;
    import Authentication.AuthView;

public class AuthController {
    
    Authentication authentication;
    AuthView authView;

    /**
     * Constructor for Authentication Controller.
     */
    public AuthController() {
        authentication = new Authentication();
        authView = new AuthView();
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
