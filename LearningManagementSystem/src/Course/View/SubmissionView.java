package Course.View;

import Course.Model.Assignment;
import User.Model.User;

import javax.swing.*;

public class SubmissionView {

    JFrame enterSubFrame;

    public SubmissionView(CourseView courseView) {

    }

    public void enterSubView(JFrame assignmentsFrame, User user, Assignment assignment) {
        enterSubFrame = new JFrame(assignment.getAssignmentName() + " Submission");
        enterSubFrame.setVisible(true);
        enterSubFrame.setSize(800, 400);
        enterSubFrame.setLocationRelativeTo(assignmentsFrame);
        enterSubFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel enterSubPanel = new JPanel();

        JLabel label = new JLabel();
        label.setText(user.getUserFirstName());
        enterSubPanel.add(label);

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            enterSubFrame.dispose();
        });
        enterSubPanel.add(back);

        enterSubFrame.add(enterSubPanel);
    }

}
