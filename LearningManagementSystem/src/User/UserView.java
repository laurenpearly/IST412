package User;

import Course.Model.Course;
import User.Model.User;

import javax.swing.*;
import java.util.ArrayList;

public class UserView {

    private UserController cntl;
    JFrame userFrame;
    JFrame courseFrame;

    /**
     * Constructor for View
     */
    public UserView(UserController cntl) {
        this.cntl = cntl;
    }

    /**
     * View user details.
     * @param user User being viewed
     */
    public void viewUser(User user) {
        System.out.println("Output from User.UserView.viewUser(): userFirstName: " + user.getUserFirstName());
        userFrame = new JFrame("View User");
        userFrame.setVisible(true);
        userFrame.setSize(800, 400);
        userFrame.setLayout(new BoxLayout(userFrame.getContentPane(), BoxLayout.Y_AXIS));
        userFrame.setLocationRelativeTo(null);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel viewUserPanel = new JPanel();
        JButton assignments = new JButton("View Courses");
        viewUserPanel.add(assignments);
        userFrame.add(viewUserPanel);
        assignments.addActionListener(event -> {
            viewCourses(user.getUserID(), cntl.viewCourses(user));
        });
    }

    /**
     * View a user's courses.
     * @param userID ID of user.
     * @param userCourses List of user's courses.
     */
    public void viewCourses(int userID, ArrayList<Course> userCourses) {
        System.out.println("Output from User.UserView.viewCourses(): userID: " + userID);
        courseFrame = new JFrame("Courses");
        courseFrame.setVisible(true);
        courseFrame.setSize(800, 400);
        courseFrame.setLocationRelativeTo(userFrame);
        courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
