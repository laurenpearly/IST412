package Course;

import Course.Model.Assignment;
import Course.Model.Course;
import Course.View.CourseView;
import User.Model.User;

import javax.swing.*;
import java.util.ArrayList;

public class CourseController {
    ArrayList<Course> courses;
    ArrayList<Assignment> assignments;
    CourseView view;

    /**
     * Constructor for Controller
     */
    public CourseController() {
        courses = new ArrayList<>();
        assignments = new ArrayList<>();
        this.view = new CourseView(this);
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
                //System.out.println("Student successfully enrolled! " + course.getTeachingTeamList().get(userID));
            }
        }
    }

    public void submitAssignment(int userID, int courseID, int assignmentID, String courseSubmission) {
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
