package Course.View;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import Data.Data;
import User.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CourseView {

    SubmissionView subView;
    GradeView gradeView;
    JFrame courseFrame;
    JFrame assignmentsFrame;
    CourseController courseCntl;

    /**
     * Constructor for View
     */
    public CourseView(CourseController courseCntl) {
        this.courseCntl = courseCntl;
        this.subView = new SubmissionView(this);
        this.gradeView = new GradeView(this);
    }

    /**
     * Displays course and its info.
     * @param user User courses are being shown for
     * @param userFrame starting point to orient GUI elements
     * @param userCourses list of user courses
     */
    public void viewCourse(Data data, User user, JFrame userFrame, ArrayList<Course> userCourses) {
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
                viewAssignments(data, user, course, courseCntl.getAssignments(course.getCourseID()));
            });
            courseButtons.add(btn);
        }
        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            courseFrame.dispose();
        });
        courseButtons.add(back);

        courseFrame.add(courseButtons);
    }

    public void viewAssignments(Data data, User user, Course course, ArrayList<Assignment> userAssignments) {
        assignmentsFrame = new JFrame(course.getCourseName() + " Assignments");
        assignmentsFrame.setVisible(true);
        assignmentsFrame.setSize(900, 400);
        assignmentsFrame.setLocationRelativeTo(courseFrame);
        assignmentsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel assignmentPanel = new JPanel();

        String headers[] = { "Name", "Description"};
        String assignmentList[][] = new String[userAssignments.size()][3];

        for (int i = 0; i < userAssignments.size(); i ++){
            assignmentList[i][0] = userAssignments.get(i).getAssignmentName();
            assignmentList[i][1] = userAssignments.get(i).getAssignmentDetails();
            assignmentList[i][2] = Integer.toString(userAssignments.get(i).getAssignmentID());
        }

        JTable assignmentsTable = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(assignmentList, headers);
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
                    subView.enterSubView(data, courseCntl, assignmentsFrame, user,
                            courseCntl.getOneAssignment(Integer.parseInt(assignmentList[assignmentsTable.getSelectedRow()][2])));
                } catch (ArrayIndexOutOfBoundsException indexOOB) {
                    JOptionPane.showMessageDialog(assignmentsFrame, "Please choose an assignment to submit to.");
                }
            });
            assignmentPanel.add(submit);
        } else {
            JButton create = new JButton("Create Assignment");
            create.addActionListener(event -> {
                courseCntl.createAssignment(data, course, assignmentsFrame);
            });
            assignmentPanel.add(create);

            JButton grade = new JButton("Grade Assignment");
            grade.addActionListener(event -> {
                try{
                    gradeView.enterGradeView(data, courseCntl, assignmentsFrame, user,
                    courseCntl.getOneAssignment(Integer.parseInt(assignmentList[assignmentsTable.getSelectedRow()][2])));
            }
            catch (ArrayIndexOutOfBoundsException indexOOB) {
                JOptionPane.showMessageDialog(assignmentsFrame, "Please choose an assignment to grade.");}
            });
            assignmentPanel.add(grade);
        }
        assignmentPanel.add(back);

        assignmentsFrame.add(assignmentPanel);
    }
}
