package User.Model.Student;

import Course.Model.Course;
import User.Model.User;

import java.util.ArrayList;

public class Student extends User {
    String grades;
    String courseSubmission;
    int userID;

    /**
     * Constructor for student
     * @param userID Student ID
     * @param userLoginName Student Username
     * @param userPassword Student Password
     * @param userFirstName Student first name
     * @param userLastName Student last name
     */
    public Student(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName) {
        super(userID, userLoginName, userPassword, userFirstName, userLastName);
        this.grades = "A";
        this.userID = userID;
    }

    /**
     * Enroll in a course
     * @param courseID ID of course to enroll in
     */
    public void enroll(int courseID) {
        System.out.println("Output from User.Model.Student.Student.enroll(): courseID: " + courseID);
    }

    /**
     * Submit an assignment to a course
     * @param courseSubmission Course to submit to
     */
    public void submitAssignment(int assignmentID, String courseSubmission) {
        this.courseSubmission = courseSubmission;
        System.out.println("Output from User.Model.Student.submitAssignment(): assignmentID: " + assignmentID +
                " courseSubmission: " + courseSubmission);
    }

    public String getGrades() {
        return grades;
    }

    public int getUserID() {
        return userID;
    }
}
