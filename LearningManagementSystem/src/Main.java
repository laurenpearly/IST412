import Authentication.AuthController;

public class Main {

    public static void main(String[] args){
        AuthController authCntl = new AuthController();
        authCntl.showLoginGUI();
    }
}