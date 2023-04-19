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
            viewCourses(cntl.viewCourses(user));
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
    public void viewAssignments(Course course, ArrayList<Assignment> userAssignments) {
        assignmentsFrame = new JFrame(course.getCourseName() + " Assignments");
        assignmentsFrame.setVisible(true);
        assignmentsFrame.setSize(800, 400);
        assignmentsFrame.setLocationRelativeTo(courseFrame);
        assignmentsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel assignmentPanel = new JPanel();

        String headers[] = { "Name", "Description"};
        String data[][] = new String[userAssignments.size()][2];

        for (int i = 0; i < userAssignments.size(); i ++){
            data[i][0] = userAssignments.get(i).getAssignmentName();
            data[i][1] = userAssignments.get(i).getAssignmentDetails();
        }

        JTable assignmentsTable = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(data, headers);
        assignmentsTable.setModel(dtm);

        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        if (defaults.get("Table.alternateRowColor") == null)
            defaults.put("Table.alternateRowColor", new Color(210, 210, 210));

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            assignmentsFrame.dispose();
        });

        assignmentPanel.add(new JScrollPane(assignmentsTable));
        assignmentPanel.add(back);
        assignmentsFrame.add(assignmentPanel);
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
