package Course.View;

import Course.CourseController;

import javax.swing.*;
import java.text.NumberFormat;

public class CreateView {

    CourseController cntl;
    JFrame courseFrame;

    public CreateView(CourseController cntl) {
        this.cntl = cntl;
    }

    public void createCourse(JFrame userFrame) {
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
            if(cntl.writeCourse(Integer.parseInt(idField.getText()), nameField.getText())) {
                JOptionPane.showMessageDialog(courseFrame, "Course created!");
                courseFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(courseFrame, "Error, could not create course.");
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
}
