package Authentication;

import Authentication.Model.Authentication;
import Data.Data;
import User.UserController;

import java.io.IOException;

public class AuthController {

    Data data;
    AuthView authView;
    Authentication auth;
    UserController userCntl;

    public AuthController() {
        authView = new AuthView(this);
        auth = new Authentication();
        userCntl = new UserController();
    }

    public void showLoginGUI() {
        authView.showGui();
    }

    public boolean authenticate(String username, char[] password) {
        return auth.authenticate(username, password);
    }

    public int checkPasswordStrength(String password) {
        return auth.checkPasswordStrength(password);
    }

    public void registerUser(String username, String password) throws IOException {
        auth.registerUser(username, password);
    }

    public void viewUser(String username) {
        data = new Data();
        switch (username) {
            case "student":
                userCntl.viewUser(data, data.getStudent());
                System.out.println("student");
                break;
            case "team":
                userCntl.viewUser(data, data.getTeachingTeam());
                System.out.println("teaching team");
                break;
            case "instructor":
                userCntl.viewUser(data, data.getInstructor());
                System.out.println("instructor");
                break;
        }
    }

}
