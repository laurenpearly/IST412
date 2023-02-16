package User.Model.Student;

import Course.Model.Course;
import User.Model.User;

import java.util.ArrayList;

public class Student extends User {
    int userID;
    String userLoginName;
    String userPassword;
    String userFirstName;
    String userLastName;
    ArrayList<Course> userCourses;
    String grades;
    String courseSubmission;

    /**
     * Constructor for student
     * @param userID Student ID
     * @param userLoginName Student Username
     * @param userPassword Student Password
     * @param userFirstName Student first name
     * @param userLastName Student last name
     * @param userCourses Student courses
     */
    public Student(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName, ArrayList<Course> userCourses) {
        super(userID, userLoginName, userPassword, userFirstName, userLastName);
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
}
