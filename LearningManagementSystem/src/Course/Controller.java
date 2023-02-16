package Course;

import Course.Model.Assignment;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;

import java.util.ArrayList;

public class Controller {
    String courseID;
    String courseName;
    ArrayList<Assignment> courseAssignments;
    String courseSubmissions;
    ArrayList<Student> studentList;
    ArrayList<TeachingTeam> teachingTeamList;
    ArrayList<Instructor> instructorList;
    int assignmentID;
    String assignmentName;
    String assignmentDetails;

    /**
     * Constructor for Controller
     */
    public Controller() {

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

    }

    /**
     * Assigns teaching team members to course.
     * @param userID ID of user to be added.
     * @param courseID ID of course to be added to.
     */
    public void assignTeachingTeam(int userID, int courseID) {

    }
}
