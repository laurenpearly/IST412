package testharness;

import Course.Model.Course;
import User.Model.Student.Student;
import User.UserController;

public class Main {
    /**
     * Start the program.
     * @param args main method
     */
    public static void main(String[] args) {
        //dummy data for tests
        Course course = new Course(0, "TestCourse");
        Student student = new Student(0, "student", "password",
                "Erik", "Student");

        //controllers to call from tests here
        UserController userCtrl = new UserController();

        //add tests here!!!
        studentTests(userCtrl, student);
    }

    public static void studentTests(UserController userCtrl, Student student) {
        System.out.println();
        System.out.println("Input from studentTests(): Authenticating student...");
        userCtrl.logIn(student.getUserLoginName(), student.getUserPassword());
        System.out.println();
        System.out.println("Input from studentTests(): Enrolling in course...");
        userCtrl.enroll(0, 0);
        System.out.println();
        System.out.println("Input from studentTests(): Enrolling in course...");
    }
}