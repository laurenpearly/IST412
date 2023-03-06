package Course;

import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;

import java.util.ArrayList;

public class CourseController {
    ArrayList<Course> courses;
    CourseView view;
    Course model;

    /**
     * Constructor for Controller
     */
    public CourseController() {
        courses = new ArrayList<Course>();
        this.model = model;
        this.view = view;
    }

    /**
     * Given the assignment ID, shows the name, details, and ID of the course it is assigned to.
     * @param assignmentID The ID given to the Assignment.
     * @param assignmentName Name given to the Assignment.
     * @param assignmentDetails Details for the Assignment.
     * @param courseID The ID of the Course the Assignment is assigned to.
     */
    public void viewAssignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {

    }

    /**
     * Displays course and its info.
     * @param courseID ID for course.
     * @param courseName Name for course.
     * @param courseAssignments Assignments in course.
     * @param courseSubmissions Submissions for course.
     * @param studentList List of students in course.
     * @param teachingTeamList List of teaching team members in course.
     * @param instructorList List of instructors in course.
     */
    public void viewCourse(int courseID, String courseName, ArrayList<Assignment> courseAssignments, String courseSubmissions, ArrayList<Student> studentList, ArrayList<TeachingTeam> teachingTeamList, ArrayList<Instructor> instructorList) {
        view.viewCourse(courseID,courseName,courseAssignments,courseSubmissions,studentList,teachingTeamList,instructorList);
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

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
