package Course;

import Course.Model.Assignment;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;

import java.util.ArrayList;

public class CourseView {
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
     * Constructor for View
     */
    public CourseView() {

    }

    /**
     * Given the assignment ID, shows the name, details, and ID of the course it is assigned to.
     * @param assignmentID The ID given to the Assignment.
     * @param assignmentName Name given to the Assignment.
     * @param assignmentDetails Details for the Assignment.
     * @param courseID The ID of the Course the Assignment is assigned to.
     */
    public void viewAssignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {
        System.out.println("Output from CourseView");
        System.out.println("Assignment ID: " + assignmentID);
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Assignment Details: " + assignmentDetails);
        System.out.println("Course ID: " + courseID);
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
        System.out.println("Output from CourseView");
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Assignments: " + courseAssignments);
        System.out.println("Course Submissions: " + courseSubmissions);
        System.out.println("Student List: " + studentList);
        System.out.println("Teaching TeamList: " + teachingTeamList);
        System.out.println("Instructor List: " + instructorList);
    }
}
