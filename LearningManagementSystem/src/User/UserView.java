package User;

import Course.Model.Course;

import java.util.ArrayList;

public class UserView {

    /**
     * Constructor for Controller
     */
    public UserView() {

    }

    /**
     * View user details.
     * @param userFirstName User first name.
     * @param userLastName User last name.
     * @param userCourses User courses.
     */
    public void viewUser(String userFirstName, String userLastName, ArrayList<Course> userCourses) {
        System.out.println("Output from User.UserView.viewUser(): userFirstName: " + userFirstName);
    }

    /**
     * View a user's courses.
     * @param userID ID of user.
     * @param userCourses List of user's courses.
     */
    public void viewCourses(int userID, ArrayList<Course> userCourses) {
        System.out.println("Output from User.UserView.viewCourses(): userID: " + userID);
    }

    /**
     * View assignments for a course.
     * @param userID ID of user.
     * @param userCourses List of courses, a course ID will be selected.
     */
    public void viewAssignments(int userID, ArrayList<Course> userCourses) {
        System.out.println("Output from User.UserView.viewAssignments(): userID: " + userID);
    }

    /**
     * View a user's messages.
     * @param userID ID of user.
     */
    public void viewMessages(int userID) {
        System.out.println("Output from User.UserView.viewMessages(): userID: " + userID);
    }

    /**
     * View grades
     * @param userID ID of user
     * @param userCourses Courses a user is enrolled in
     * @param grades Grades for the courses
     */
    public void viewGrades(int userID, ArrayList<Course> userCourses, String grades) {
        System.out.println("Output from User.UserView.viewGrades(): userID: " + userID + " grades: " + grades);
    }
}
