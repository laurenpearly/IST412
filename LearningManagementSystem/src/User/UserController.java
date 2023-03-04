package User;

import Authentication.AuthController;
import Course.Model.Course;

import java.util.ArrayList;

public class UserController {
    int userID;
    String userLoginName;
    String userPassword;
    String userFirstName;
    String userLastName;
    ArrayList<Course> userCourses;
    String grades;
    String courseSubmission;
    UserView userView;

    /**
     * Constructor for Controller
     */
    public UserController() {
        userView = new UserView();
    }

    /**
     * View user details.
     * @param userFirstName User first name.
     * @param userLastName User last name.
     * @param userCourses User courses.
     */
    public void viewUser(String userFirstName, String userLastName, ArrayList<Course> userCourses) {
        userView.viewUser(userFirstName, userLastName, userCourses);
    }

    /**
     * View a user's courses.
     * @param userID ID of user.
     * @param userCourses List of user's courses.
     */
    public void viewCourses(String userID, ArrayList<Course> userCourses) {
        userView.viewCourses(userID, userCourses);
    }

    /**
     * View assignments for a course.
     * @param userID ID of user.
     * @param userCourses List of courses, a course ID will be selected.
     */
    public void viewAssignments(String userID, ArrayList<Course> userCourses) {
        userView.viewAssignments(userID, userCourses);
    }

    /**
     * View a user's messages.
     * @param userID ID of user.
     */
    public void viewMessages(String userID) {
        userView.viewMessages(userID);
    }

    /**
     * User logs in.
     * @param userLoginName Username.
     * @param userPassword Password.
     */
    public void logIn(String userLoginName, String userPassword) {
        AuthController auth = new AuthController();
        auth.authenticate(userLoginName, userPassword);
    }

    /**
     * Enroll in a course
     * @param userID ID of user
     * @param courseID ID of course to enroll in
     */
    public void enroll(int userID, int courseID) {

    }

    /**
     * Submit an assignment to a course
     * @param userID ID of user
     * @param courseSubmission Course to submit to
     */
    public void submitAssignment(int userID, String courseSubmission) {

    }

    /**
     * View grades
     * @param userID ID of user
     * @param userCourses Courses a user is enrolled in
     * @param grades Grades for the courses
     */
    public void viewGrades(int userID, ArrayList<Course> userCourses, String grades) {

    }

    /**
     * Used to assign a user to teach a course
     * @param courseID ID of course to be taught
     * @param userID ID of user to teach
     */
    public void teachCourse(int courseID, int userID) {

    }

    /**
     * Grade assignments for a course
     * @param courseID ID of course to grade
     * @param userCourses Assignments can be obtained in this list
     */
    public void gradeAssignment(int courseID, ArrayList<Course> userCourses) {

    }

    /**
     * Creates a course
     * @param courseID ID of course to be made
     * @param courseName Name of course
     * @param courseDetails Details of course
     */
    public void createCourse(int courseID, String courseName, String courseDetails) {

    }

    /**
     * Creates an assignment for a course
     * @param courseID ID of course to create assignment for
     * @param assignmentID ID of assignment being made
     * @param assignmentName Name of assignment
     * @param assignmentDetails Details of assignment
     */
    public void createAssignment(int courseID, int assignmentID, String assignmentName, String assignmentDetails) {

    }
}
