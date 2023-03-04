package User;

import Course.Model.Course;

import java.util.ArrayList;

public class UserView {
    int userID;
    String userFirstName;
    String userLastName;
    ArrayList<Course> userCourses;
    String grades;
    String courseSubmission;

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
        System.out.println("Output from User.UserView: userFirstName: " + userFirstName);
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

    /**
     * View grades
     * @param userID ID of user
     * @param userCourses Courses a user is enrolled in
     * @param grades Grades for the courses
     */
    public void viewGrades(int userID, ArrayList<Course> userCourses, String grades) {

    }
}
