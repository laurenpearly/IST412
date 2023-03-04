package testharness;

import Course.Model.Assignment;
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
        Course course = new Course(24, "TestCourse");
        Assignment assignment = new Assignment(28, "testAssignment", "details", 24);
        Student student = new Student(0, "student", "password",
                "Erik", "Student");

        //controllers to call from tests here
        UserController userCtrl = new UserController();

        //add tests here!!!
        studentTests(userCtrl, student, course, assignment);
    }

    public static void studentTests(UserController userCtrl, Student student, Course course, Assignment assignment) {
        System.out.println();
        System.out.println("Input from studentTests(): Authenticating student...");
        userCtrl.logIn(student.getUserLoginName(), student.getUserPassword());
        System.out.println();
        System.out.println("Input from studentTests(): Enrolling in course...");
        userCtrl.enroll(student, course.getCourseID());
        System.out.println();
        System.out.println("Input from studentTests(): Viewing Student...");
        userCtrl.viewUser(student);
        System.out.println();
        System.out.println("Input from studentTests(): Viewing Courses...");
        userCtrl.viewCourses(student);
        System.out.println();
        System.out.println("Input from studentTests(): Viewing Assignments...");
        userCtrl.viewAssignments(student, course.getCourseID());
        System.out.println();
        System.out.println("Input from studentTests(): Viewing Messages...");
        userCtrl.viewMessages(student);
        System.out.println();
        System.out.println("Input from studentTests(): Submitting Content...");
        userCtrl.submitAssignment(student, course.getCourseID(), assignment.getAssignmentID(), "testSubmission");
        System.out.println();
        System.out.println("Input from studentTests(): Viewing Grades...");
        userCtrl.viewGrades(student);
    }
}