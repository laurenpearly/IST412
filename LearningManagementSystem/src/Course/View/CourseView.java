package Course.View;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CourseView {

    SubmissionView subView;
    JFrame courseFrame;
    JFrame assignmentsFrame;
    CourseController courseCntl;

    /**
     * Constructor for View
     */
    public CourseView(CourseController courseCntl) {
        this.courseCntl = courseCntl;
        this.subView = new SubmissionView(this);
    }

    /**
     * Given the assignment ID, shows the name, details, and ID of the course it is assigned to.
     * @param assignmentID The ID given to the Assignment.
     * @param assignmentName Name given to the Assignment.
     * @param assignmentDetails Details for the Assignment.
     * @param courseID The ID of the Course the Assignment is assigned to.
     */
    public void viewAssignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {
        System.out.println("Output from CourseView");
        System.out.println("Assignment ID: " + assignmentID);
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Assignment Details: " + assignmentDetails);
        System.out.println("Course ID: " + courseID);
    }

    /**
     * Displays course and its info.
     * @param user User courses are being shown for
     * @param userFrame starting point to orient GUI elements
     * @param userCourses list of user courses
     */
    public void viewCourse(User user, JFrame userFrame, ArrayList<Course> userCourses) {
        System.out.println("Output from CourseView");
        courseFrame = new JFrame("Courses");
        courseFrame.setVisible(true);
        courseFrame.setSize(800, 400);
        courseFrame.setLocationRelativeTo(userFrame);
        courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel courseButtons = new JPanel();
        for (Course course : userCourses) {
            JButton btn = new JButton(course.getCourseName());
            btn.addActionListener(event -> {
                viewAssignments(user, course, courseCntl.getAssignments(course.getCourseID()));
            });
            courseButtons.add(btn);
        }
        courseFrame.add(courseButtons);
    }

    public void viewAssignments(User user, Course course, ArrayList<Assignment> userAssignments) {
        assignmentsFrame = new JFrame(course.getCourseName() + " Assignments");
        assignmentsFrame.setVisible(true);
        assignmentsFrame.setSize(800, 400);
        assignmentsFrame.setLocationRelativeTo(courseFrame);
        assignmentsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel assignmentPanel = new JPanel();

        String headers[] = { "Name", "Description"};
        String data[][] = new String[userAssignments.size()][3];

        for (int i = 0; i < userAssignments.size(); i ++){
            data[i][0] = userAssignments.get(i).getAssignmentName();
            data[i][1] = userAssignments.get(i).getAssignmentDetails();
            data[i][2] = Integer.toString(userAssignments.get(i).getAssignmentID());
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

        if(user.getUserType() == 0) {
            JButton submit = new JButton("Submit Assignment");
            submit.addActionListener(event -> {
                try {
                    subView.enterSubView(assignmentsFrame, user,
                            courseCntl.getOneAssignment(Integer.parseInt(data[assignmentsTable.getSelectedRow()][2])));
                } catch (ArrayIndexOutOfBoundsException indexOOB) {
                    JOptionPane.showMessageDialog(assignmentsFrame, "Please choose an assignment to submit to.");
                }
            });
            assignmentPanel.add(submit);
        } else {
            JButton grade = new JButton("Grade Assignment");
            assignmentPanel.add(grade);
        }
        assignmentPanel.add(back);

        assignmentsFrame.add(assignmentPanel);
    }
}
