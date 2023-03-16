package User.Model.TeachingTeam;

import Course.Model.Course;
import User.Model.User;

import java.util.ArrayList;

public class TeachingTeam extends User {

    /**
     * Constructor for teaching team
     * @param userID Teaching team ID
     * @param userLoginName Teaching team Username
     * @param userPassword Teaching team Password
     * @param userFirstName Teaching team first name
     * @param userLastName Teaching team last name
     */
    public TeachingTeam(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName) {
        super(userID, userLoginName, userPassword, userFirstName, userLastName);
    }

    /**
     * Used to assign a user to teach a course
     * @param courseID ID of course to be taught
     */
    public void teachCourse(int courseID) {
        System.out.println("Output from User.Model.TeachingTeam.TeachingTeam.teachCourse(): courseID: " + courseID);
    }

    /**
     * Grade assignments for a course
     * @param courseID ID of course to grade
     * @param assignmentID Assignment being graded
     */
    public void gradeAssignment(int courseID, int assignmentID) {
        System.out.println("Output from User.Model.TeachingTeam.TeachingTeam.gradeAssignment(): courseID: " +
                courseID + " assignmentID: " + assignmentID);
    }
}
