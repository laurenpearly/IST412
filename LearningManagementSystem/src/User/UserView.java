package User;

import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserView {

    private UserController cntl;
    JFrame userFrame;
    JFrame courseFrame;
    JFrame assignmentsFrame;

    /**
     * Constructor for View
     */
    public UserView(UserController cntl) {
        this.cntl = cntl;
    }

    private NavigationTabManager navTabManager;

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
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel viewUserPanel = new JPanel();

        JButton courses = new JButton("View Courses");
        courses.addActionListener(event -> {
            cntl.viewCourses(user, userFrame);
        });
        viewUserPanel.add(courses);

        if(user.getUserType() == 0) {
            JButton submit = new JButton("Submit Assignment");
            viewUserPanel.add(submit);
        } else {
            JButton grade = new JButton("Grade Assignment");
            viewUserPanel.add(grade);
        }

        userFrame.add(viewUserPanel);
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

    public void viewGrade(String courseName, Double grade) {
        System.out.println("Output from updated User.UserView.viewGrade(): Course Name: " + courseName + " grade: " + grade);
    }
}
