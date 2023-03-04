package testharness;

import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;
import User.Model.User;
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
        TeachingTeam teachingTeam = new TeachingTeam(1, "teachteam", "tpassword",
                "Sara", "TeachTeam");
        Instructor instructor = new Instructor(2, "instructor", "ipassword",
                "John", "Instructor");
        Student student = new Student(0, "student", "spassword",
                "Erik", "Student");

        //controllers to call from tests here
        UserController userCtrl = new UserController();

        //add tests here!!!
        instructorTests(userCtrl, instructor, course, assignment);
        teachingTeamTests(userCtrl, teachingTeam, course, assignment);
        studentTests(userCtrl, student, course, assignment);
    }

    public static void instructorTests(UserController userCtrl, Instructor instructor, Course course, Assignment assignment) {
        System.out.println();
        System.out.println("Input from instructorTests(): Authenticating teaching team...");
        userCtrl.logIn(instructor.getUserLoginName(), instructor.getUserPassword());
        System.out.println();
        System.out.println("Input from instructorTests(): Teaching course...");
        userCtrl.teachCourse(instructor, course.getCourseID());
        System.out.println();
        System.out.println("Input from instructorTests(): Grading assignment...");
        userCtrl.gradeAssignment(instructor, course.getCourseID(), assignment.getAssignmentID());
        System.out.println();
        System.out.println("Input from instructorTests(): Creating course...");
        userCtrl.createCourse(instructor, 40, "TestCourseCreated");
        System.out.println();
        System.out.println("Input from instructorTests(): Creating assignment...");
        userCtrl.createAssignment(instructor, 40, 64, "TestAssignmentCreated", "testDetails");
        System.out.println();
        System.out.println("Instructor tests done!");
        System.out.println();
    }

    public static void teachingTeamTests(UserController userCtrl, TeachingTeam teachingTeam, Course course, Assignment assignment) {
        System.out.println();
        System.out.println("Input from teachingTeamTests(): Authenticating teaching team...");
        userCtrl.logIn(teachingTeam.getUserLoginName(), teachingTeam.getUserPassword());
        System.out.println();
        System.out.println("Input from teachingTeamTests(): Teaching course...");
        userCtrl.teachCourse(teachingTeam, course.getCourseID());
        System.out.println();
        System.out.println("Input from teachingTeamTests(): Grading assignment...");
        userCtrl.gradeAssignment(teachingTeam, course.getCourseID(), assignment.getAssignmentID());
        System.out.println();
        System.out.println("Teaching Team tests done!");
        System.out.println();
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
        System.out.println();
        System.out.println("Student tests done!");
        System.out.println();
    }
}