package User;

import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.User;

import javax.swing.*;
import java.awt.*;
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
            viewCourses(cntl.viewCourses(user));
        });
    }

    /**
     * View a user's courses.
     * @param userCourses List of user's courses.
     */
    public void viewCourses(ArrayList<Course> userCourses) {
        courseFrame = new JFrame("Courses");
        courseFrame.setVisible(true);
        courseFrame.setSize(800, 400);
        courseFrame.setLocationRelativeTo(userFrame);
        courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel courseButtons = new JPanel();
        for (Course course : userCourses) {
            JButton btn = new JButton(course.getCourseName());
            btn.addActionListener(event -> {
                viewAssignments(course, cntl.viewAssignments(course.getCourseID()));
            });
            courseButtons.add(btn);
        }
        courseFrame.add(courseButtons);

    }

    /**
     * View assignments for a course.
     * @param course Course.
     */
    public void viewAssignments(Course course, ArrayList<Assignment> assignments) {
        System.out.println("Output from User.UserView.viewAssignments(): coursename: " + course.getCourseName());
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
