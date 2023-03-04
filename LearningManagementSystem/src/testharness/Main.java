package testharness;

import User.Model.Student.Student;
import User.UserController;

public class Main {
    /**
     * Start the program.
     * @param args main method
     */
    public static void main(String[] args) {
        UserController userCtrl = new UserController();
        //add tests here!!!
        studentTests(userCtrl);
    }

    public static void studentTests(UserController userCtrl) {
        System.out.println("Input from studentTests(): Creating student...");
        Student student = new Student(0, "student", "password",
                "Erik", "Student");
        System.out.println("Input from studentTests(): Authenticating student...");
        userCtrl.logIn(student.getUserLoginName(), student.getUserPassword());
    }
}