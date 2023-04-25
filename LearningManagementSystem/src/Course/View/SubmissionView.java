package Course.View;

import Course.CourseController;
import Course.Model.Assignment;
import Data.Data;
import User.Model.User;

import javax.swing.*;

public class SubmissionView {

    JFrame enterSubFrame;

    public SubmissionView(CourseView courseView) {

    }

    public void enterSubView(Data data, CourseController courseCntl, JFrame assignmentsFrame, User user, Assignment assignment) {
        enterSubFrame = new JFrame(assignment.getAssignmentName() + " Submission");
        enterSubFrame.setVisible(true);
        enterSubFrame.setSize(800, 400);
        enterSubFrame.setLocationRelativeTo(assignmentsFrame);
        enterSubFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel enterSubPanel = new JPanel();

        JLabel subLabel = new JLabel("Enter Submission:");
        JTextArea submission = new JTextArea(20, 40);
        submission.setLineWrap(true);
        enterSubPanel.add(subLabel);
        enterSubPanel.add(submission);

        JButton submit = new JButton("Submit Assignment");
        submit.addActionListener(event -> {
            String submissionString = submission.getText();
            if(courseCntl.submitAssignment(data, user, assignment, submissionString)) {
                JOptionPane.showMessageDialog(enterSubFrame, "Assignment successfully submitted!");
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
