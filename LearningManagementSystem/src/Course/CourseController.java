package Course;

import Course.Model.Assignment;
import Course.Model.Course;
import Course.View.CourseView;
import Course.View.CreateView;
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
    public void viewCourses(User user, JFrame userFrame) {
        ArrayList<Course> userCourses = getCourses(user.getUserCourses());
        view.viewCourse(user, userFrame, userCourses);
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

    /**
     * Enrolls student to course.
     * @param userID ID of user to be added.
     * @param courseID ID of course to be added to.
     */
    public void enroll(int userID, int courseID) {
        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                course.enroll(userID);
                System.out.println("Student successfully enrolled!");
            }
        }
    }

    public boolean submitAssignment(User user, Assignment assignment, String submission) {
        return assignment.submitAssignment(this, user, submission);
    }

    public boolean gradeAssignment(User user, Assignment assignment, double grade) {
        return assignment.gradeAssignment(this, user, grade);
    }

    public void createCourse(JFrame userFrame) {
        create.createCourse(userFrame);
    }

    public boolean writeCourse(int id, String name) {
        Course course = new Course(id, name);
        if(course.writeCourse()) {
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
