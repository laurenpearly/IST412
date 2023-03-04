package User.Model;

import Course.Model.Course;

import java.util.ArrayList;

public class User {
    int userID;
    String userLoginName;
    String userPassword;
    String userFirstName;
    String userLastName;
    ArrayList<Course> userCourses;

    /**
     * Constructor for base user of system.
     * @param userID ID of user.
     * @param userLoginName Username of user.
     * @param userPassword Password of user.
     * @param userFirstName First name of user.
     * @param userLastName Last name of user.
     */
    public User(int userID, String userLoginName, String userPassword, String userFirstName, String userLastName) {

    }

    /**
     * View user details.
     * @param userFirstName User first name.
     * @param userLastName User last name.
     * @param userCourses User courses.
     */
    public void viewUser(String userFirstName, String userLastName, ArrayList<Course> userCourses) {

    }

    /**
     * View a user's courses.
     * @param userID ID of user.
     * @param userCourses List of user's courses.
     */
    public void viewCourses(String userID, ArrayList<Course> userCourses) {

    }

    /**
     * View assignments for a course.
     * @param userID ID of user.
     * @param userCourses List of courses, a course ID will be selected.
     */
    public void viewAssignments(String userID, ArrayList<Course> userCourses) {

    }

    /**
     * View a user's messages.
     * @param userID ID of user.
     */
    public void viewMessages(String userID) {

    }

    public int getUserID() {
        return userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
