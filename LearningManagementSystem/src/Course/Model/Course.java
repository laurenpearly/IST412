package Course.Model;

import User.Model.Student.Student;
import User.Model.TeachingTeam.*;

import java.util.ArrayList;

public class Course {
    int courseID;
    String courseName;
    ArrayList<Assignment> courseAssignments;
    String courseSubmissions;
    ArrayList<Student> studentList;
    ArrayList<TeachingTeam> teachingTeamList;
    ArrayList<Instructor> instructorList;

    /**
     * Constructor for new Course
     * @param courseID ID to be set for Course.
     * @param courseName Name to be set for Course.
     */
    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
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
     */
    public void assignTeachingTeam(int userID) {

    }

    /**
     * Enrolls students into course.
     * @param userID ID of user to be added.
     */
    public void enroll(int userID) {

    }
}
