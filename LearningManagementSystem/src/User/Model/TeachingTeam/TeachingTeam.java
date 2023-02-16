package User.Model.TeachingTeam;

import Course.Model.Course;
import User.Model.User;

import java.util.ArrayList;

public class TeachingTeam extends User {
    int userID;
    String userLoginName;
    String userPassword;
    String userFirstName;
    String userLastName;
    ArrayList<Course> userCourses;

    /**
     * Constructor for teaching team
     * @param userID Teaching team ID
     * @param userLoginName Teaching team Username
     * @param userPassword Teaching team Password
     * @param userFirstName Teaching team first name
     * @param userLastName Teaching team last name
     * @param userCourses Teaching team courses
     */
    public TeachingTeam(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName, ArrayList<Course> userCourses) {
        super(userID, userLoginName, userPassword, userFirstName, userLastName);
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
}
