package Course.View;

import Course.CourseController;
import Course.Model.Course;
import Data.Data;

import javax.swing.*;
import java.text.NumberFormat;

public class CreateView {

    CourseController cntl;
    JFrame courseFrame;
    JFrame assignmentFrame;

    public CreateView(CourseController cntl) {
        this.cntl = cntl;
    }

    public void createCourse(Data data, JFrame userFrame) {
        courseFrame = new JFrame("Create Course");
        courseFrame.setVisible(true);
        courseFrame.setSize(800, 400);
        courseFrame.setLocationRelativeTo(userFrame);
        courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel coursePanel = new JPanel();

        JLabel idLabel = new JLabel("Course ID:");
        JLabel nameLabel = new JLabel("Name:");
        JFormattedTextField idField = new JFormattedTextField(NumberFormat.getNumberInstance());
        JTextField nameField = new JTextField();
        idField.setColumns(30);
        nameField.setColumns(30);

        coursePanel.add(idLabel);
        coursePanel.add(idField);
        coursePanel.add(nameLabel);
        coursePanel.add(nameField);

        JButton create = new JButton("Create Course");
        create.addActionListener(event -> {
            try {
                if(idField.getText().equals("") || nameField.getText().equals("")) {
                    JOptionPane.showMessageDialog(courseFrame, "Error, please enter information.");
                } else if(cntl.writeCourse(data, Integer.parseInt(idField.getText()), nameField.getText())) {
                    JOptionPane.showMessageDialog(courseFrame, "Course created!");
                    courseFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(courseFrame, "Error, could not create course.");
                }
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(courseFrame, "Error, please enter an integer for Course ID.");
            }
        });

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            courseFrame.dispose();
        });

        coursePanel.add(create);
        coursePanel.add(back);
        courseFrame.add(coursePanel);
    }

    public void createAssignment(Data data, Course course, JFrame userFrame) {
        assignmentFrame = new JFrame("Create Assignment");
        assignmentFrame.setVisible(true);
        assignmentFrame.setSize(800, 400);
        assignmentFrame.setLocationRelativeTo(userFrame);
        assignmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel assignmentPanel = new JPanel();

        JLabel idLabel = new JLabel("Assignment ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel detailLabel = new JLabel("Details:");
        JFormattedTextField idField = new JFormattedTextField(NumberFormat.getNumberInstance());
        JTextField nameField = new JTextField();
        JTextField detailField = new JTextField();
        idField.setColumns(30);
        nameField.setColumns(30);
        detailField.setColumns(30);

        assignmentPanel.add(idLabel);
        assignmentPanel.add(idField);
        assignmentPanel.add(nameLabel);
        assignmentPanel.add(nameField);
        assignmentPanel.add(detailLabel);
        assignmentPanel.add(detailField);

        JButton create = new JButton("Create Assignment");
        create.addActionListener(event -> {
            try {
                if(idField.getText().equals("") || nameField.getText().equals("")) {
                    JOptionPane.showMessageDialog(assignmentFrame, "Error, please enter information.");
                } else if(cntl.writeAssignment(data, Integer.parseInt(idField.getText()), nameField.getText(),
                        detailField.getText(), course.getCourseID())) {
                    JOptionPane.showMessageDialog(assignmentFrame, "Assignment created!");
                    assignmentFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(assignmentFrame, "Error, could not create assignment.");
                }
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(assignmentFrame, "Error, please enter an integer for ID.");
            }
        });

        JButton back = new JButton("Back");
        back.addActionListener(event -> {
            courseFrame.dispose();
        });

        assignmentPanel.add(create);
        assignmentPanel.add(back);
        assignmentFrame.add(assignmentPanel);
    }
}
