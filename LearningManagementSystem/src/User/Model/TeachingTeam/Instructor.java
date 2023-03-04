package User.Model.TeachingTeam;

import Course.Model.Course;

import java.util.ArrayList;

public class Instructor extends TeachingTeam {

    /**
     * Constructor for teaching team
     * @param userID Teaching team ID
     * @param userLoginName Teaching team Username
     * @param userPassword Teaching team Password
     * @param userFirstName Teaching team first name
     * @param userLastName Teaching team last name
     */
    public Instructor(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName) {
        super(userID, userLoginName, userPassword, userFirstName, userLastName);
    }

    /**
     * Creates a course
     * @param courseID ID of course to be made
     * @param courseName Name of course
     */
    public void createCourse(int courseID, String courseName) {
        System.out.println("Output from User.Model.TeachingTeam.Instructor.createCourse(): courseName: " + courseName);
    }

    /**
     * Creates an assignment for a course
     * @param courseID ID of course to create assignment for
     * @param assignmentID ID of assignment being made
     * @param assignmentName Name of assignment
     * @param assignmentDetails Details of assignment
     */
    public void createAssignment(int courseID, int assignmentID, String assignmentName, String assignmentDetails) {
        System.out.println("Output from User.Model.TeachingTeam.Instructor.createAssignment(): courseID: " + courseID +
                " assignmentName: " + assignmentName);
    }
}
