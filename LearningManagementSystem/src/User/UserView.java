package User;

import Data.Data;
import User.Model.User;

import javax.swing.*;

public class UserView {

    private UserController cntl;
    JFrame userFrame;

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
    public void viewUser(Data data, User user) {
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

        if(user.getUserType() == 2) {
            JButton createCourse = new JButton("Create Course");
            createCourse.addActionListener(event -> {
                cntl.createCourse(data, userFrame);
            });
            viewUserPanel.add(createCourse);
        }

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            userFrame.dispose();
        });
        viewUserPanel.add(back);

        userFrame.add(viewUserPanel);
    }

    /**
     * View a user's messages.
     * @param userID ID of user.
     */
    public void viewMessages(int userID) {
        System.out.println("Output from User.UserView.viewMessages(): userID: " + userID);
    }
}
