package Course;

import Course.Model.Assignment;
import Course.Model.Course;
import Course.View.CourseView;
import Course.View.CreateView;
import Data.Data;
import User.Model.User;

import javax.swing.*;
import java.util.ArrayList;

public class CourseController {
    ArrayList<Course> courses;
    ArrayList<Assignment> assignments;
    CourseView view;
    CreateView create;

    /**
     * Constructor for Controller
     */
    public CourseController() {
        this.courses = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.view = new CourseView(this);
        this.create = new CreateView(this);
    }

    /**
     * Displays course and its info.
     * @param user User courses being shown for
     * @param userFrame starting point for GUI
     */
    public void viewCourses(Data data, User user, JFrame userFrame) {
        ArrayList<Course> userCourses = getCourses(user.getUserCourses());
        view.viewCourse(data, user, userFrame, userCourses);
    }

    /**
     * Assigns teaching team members to course.
     * @param userID ID of user to be added.
     * @param courseID ID of course to be added to.
     */
    public void assignTeachingTeam(int userID, int courseID) {
        for (Course course : courses) {
            if (course.getCourseID()==courseID) {
                course.assignTeachingTeam(userID);
                System.out.println("Teaching Team successfully assigned!");
                //System.out.println("Teaching Team successfully assigned: " + course.getTeachingTeamList().get(userID));
            }
        }
    }

    public boolean submitAssignment(Data data, User user, Assignment assignment, String submission) {
        return assignment.submitAssignment(data, user, submission);
    }

    public boolean gradeAssignment(Data data, User user, Assignment assignment, double grade) {
        return assignment.gradeAssignment(data, this, user, grade);
    }

    public void createCourse(Data data, JFrame userFrame) {
        create.createCourse(data, userFrame);
    }

    public void createAssignment(Data data, Course course, JFrame assignmentFrame) {
        create.createAssignment(data, course, assignmentFrame);
    }

    public boolean writeCourse(Data data, int id, String name) {
        Course course = new Course(id, name);
        if(course.writeCourse(data)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean writeAssignment(Data data, int id, String name, String details, int courseID) {
        Assignment assignment = new Assignment(id, name, details, courseID);
        if(assignment.writeAssignment(data)) {
            return true;
        } else {
            return false;
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public ArrayList<Course> getCourses(ArrayList<Integer> courseIds) {
        ArrayList<Course> userCourses = new ArrayList<>();
        for (Integer i : courseIds) {
            for (Course c : courses) {
                if (i == c.getCourseID()) {
                    userCourses.add(c);
                }
            }
        }
        return userCourses;
    }

    public Assignment getOneAssignment(int assignmentID) {
        for (Assignment a : assignments) {
            if (a.getAssignmentID() == assignmentID) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Assignment> getAssignments(int courseID) {
        ArrayList<Assignment> userAssignments = new ArrayList<>();
        for (Assignment a : assignments) {
            if (courseID == a.getCourseID()) {
                userAssignments.add(a);
            }
        }
        return userAssignments;
    }
}
