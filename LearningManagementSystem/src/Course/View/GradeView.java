package Course.View;

import Course.CourseController;
import Course.Model.Assignment;
import Data.Data;
import User.Model.User;

import javax.swing.*;

public class GradeView {

    JFrame enterSubFrame;

    public GradeView(CourseView courseView) {

    }

    public void enterGradeView(Data data, CourseController courseCntl, JFrame assignmentsFrame, User user, Assignment assignment) {
        enterSubFrame = new JFrame(assignment.getAssignmentName() + " Submission");
        enterSubFrame.setVisible(true);
        enterSubFrame.setSize(800, 400);
        enterSubFrame.setLocationRelativeTo(assignmentsFrame);
        enterSubFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel enterSubPanel = new JPanel();

        JLabel subLabel = new JLabel("Enter Grade (Numbered Score Only):");
        JTextArea submission = new JTextArea(20, 40);
        submission.setLineWrap(true);
        enterSubPanel.add(subLabel);
        enterSubPanel.add(submission);

        JButton submit = new JButton("Submit Grade");
        submit.addActionListener(event -> {
            Double grade = Double.parseDouble(submission.getText());
            if(courseCntl.gradeAssignment(data, user, assignment, grade)) {
                JOptionPane.showMessageDialog(enterSubFrame, "Assignment successfully Graded!");
                enterSubFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(enterSubFrame, "Error, could not submit assignment.");
            }
        });

        enterSubPanel.add(submit);

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            enterSubFrame.dispose();
        });
        enterSubPanel.add(back);

        enterSubFrame.add(enterSubPanel);
    }
}