package User;

import Authentication.AuthController;
import Course.CourseController;
import Course.Model.Course;
import Message.MessageController;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;
import User.Model.User;

import java.util.ArrayList;

public class UserController {
    UserView userView;
    //AuthController authCtrl;
    CourseController courseCtrl;
    MessageController messageCtrl;
    ArrayList<Student> studentList;

    /**
     * Constructor for Controller
     */
    public UserController() {
        //authCtrl = new AuthController();
        courseCtrl = new CourseController();
        messageCtrl = new MessageController();
        userView = new UserView(this);
        studentList = new ArrayList<Student>();
    }

    /**
     * View user details.
     * @param student Student being viewed.
     */
    public void viewUser(Student student) {
        System.out.println("Passing through UserController.viewUser()...");
        //student.viewUser(student.getUserFirstName(), student.getUserLastName(), student.getUserCourses());
        userView.viewUser(student);
    }

    /**
     * View a user's courses.
     * @param user User whose courses are being viewed
     */
    public ArrayList<Course> viewCourses(User user) {
        System.out.println("Passing through UserController.viewCourses()...");
        ArrayList<Course> courses = new ArrayList<>(courseCtrl.getCourses(user.getUserCourses()));
        return courses;
    }

    /**
     * View assignments for a course.
     * @param user User whose assignments are being viewed.
     * @param course Course whose assignments are being viewed.
     */
    public void viewAssignments(User user, Course course) {
        System.out.println("Passing through UserController.viewAssignments()...");
        //user.viewAssignments(courseID);
        userView.viewAssignments(user.getUserID(), course);
    }

    /**
     * View a user's messages.
     * @param user User whose messages are being viewed.
     */
    public void viewMessages(User user) {
        System.out.println("Passing through UserController.viewMessages()...");
        userView.viewMessages(user.getUserID());
    }

    /**
     * User logs in.
     * @param userLoginName Username.
     * @param userPassword Password.
     */
    public void logIn(String userLoginName, String userPassword) {
        System.out.println("Passing through UserController.logIn()...");
        //authCtrl.authenticate(userLoginName, userPassword);
    }

    /**
     * Enroll in a course
     * @param student Student to enroll
     * @param courseID ID of course to enroll in
     */
    public void enroll(Student student, int courseID) {
        System.out.println("Passing through UserController.enroll()...");
        student.enroll(courseID);
        courseCtrl.enroll(student.getUserID(), courseID);
    }

    /**
     * Submit an assignment to a course
     * @param student Student who is submitting
     * @param courseID Course being submitted to
     * @param assignmentID Assignment being submitted
     * @param courseSubmission Submission
     */
    public void submitAssignment(Student student, int courseID, int assignmentID, String courseSubmission) {
        System.out.println("Passing through User.UserController.submitAssignment()...");
        student.submitAssignment(assignmentID, courseSubmission);
        courseCtrl.submitAssignment(student.getUserID(), courseID, assignmentID, courseSubmission);
    }

    /**
     * View grades
     * @param student Student whose grades are being viewed
     */
    public void viewGrades(Student student) {
        System.out.println("Passing through User.UserController.viewGrades()...");
        //userView.viewGrades(student.getUserID(), student.getUserCourses(), student.getGrades());
    }

    /**
     * Used to assign a user to teach a course
     * @param teachingTeam TeachingTeam person teaching the course
     * @param courseID ID of course to be taught
     */
    public void teachCourse(TeachingTeam teachingTeam, int courseID) {
        System.out.println("Passing through User.UserController.teachCourse()...");
        teachingTeam.teachCourse(courseID);
    }

    /**
     * Grade assignments for a course
     * @param teachingTeam User that is the grader
     * @param courseID ID of course to grade
     * @param assignmentID Assignment being graded
     */
    public void gradeAssignment(TeachingTeam teachingTeam, int courseID, int assignmentID) {
        System.out.println("Passing through User.UserController.gradeAssignment()...");
        teachingTeam.gradeAssignment(courseID, assignmentID);
    }

    /**
     * Creates a course
     * @param instructor Instructor creating the course
     * @param courseID ID of course to be made
     * @param courseName Name of course
     */
    public void createCourse(Instructor instructor, int courseID, String courseName) {
        System.out.println("Passing through User.UserController.createCourse()...");
        instructor.createCourse(courseID, courseName);
    }

    /**
     * Creates an assignment for a course
     * @param instructor Instructor creating the assignment
     * @param courseID ID of course to create assignment for
     * @param assignmentID ID of assignment being made
     * @param assignmentName Name of assignment
     * @param assignmentDetails Details of assignment
     */
    public void createAssignment(Instructor instructor, int courseID, int assignmentID, String assignmentName, String assignmentDetails) {
        System.out.println("Passing through User.UserController.createAssignment()...");
        instructor.createAssignment(courseID, assignmentID, assignmentName, assignmentDetails);
    }
}
