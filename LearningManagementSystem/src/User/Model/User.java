package User.Model;

import Course.Model.Course;

import java.util.ArrayList;

public class User {
    int userID;
    int userType;
    String userLoginName;
    String userPassword;
    String userFirstName;
    String userLastName;
    ArrayList<Integer> userCourses;

    /**
     * Constructor for base user of system.
     * @param userID ID of user.
     * @param userLoginName Username of user.
     * @param userPassword Password of user.
     * @param userFirstName First name of user.
     * @param userLastName Last name of user.
     */
    public User(int userID, int userType, String userLoginName, String userPassword, String userFirstName, String userLastName) {
        this.userID = userID;
        this.userType = userType;
        this.userLoginName = userLoginName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCourses = new ArrayList<>();
    }

    /**
     * View user details.
     * @param userFirstName User first name.
     * @param userLastName User last name.
     * @param userCourses User courses.
     */
    /*public void viewUser(String userFirstName, String userLastName, ArrayList<Course> userCourses) {
        System.out.println("Output from User.User.viewUser(): userFirstName: " + userFirstName);
    }*/

    /**
     * View assignments for a course.
     * @param courseID Course ID whose assignments are being viewed
     */
    public void viewAssignments(int courseID) {
        System.out.println("Output from User.User.viewAssignment(): courseID: " + courseID);
    }

    public int getUserID() {
        return userID;
    }

    public int getUserType() {
        return userType;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public ArrayList<Integer> getUserCourses() {
        return userCourses;
    }

    public void addUserCourses(int courseID) {
        userCourses.add(courseID);
    }
}
