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
        this.teachingTeamList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    /**
     * Assigns teaching team members to course.
     * @param userID ID of user to be added.
     */
    public void assignTeachingTeam(int userID) {
        System.out.println("Entered assignTeachingTeam function in Course.java");
        for (TeachingTeam teach : teachingTeamList) {
            if (teach.getUserID()==userID) {
                this.teachingTeamList.add(teach);
                break;
            }
        }
    }

    /**
     * Enrolls students into course.
     * @param userID ID of user to be added.
     */
    public void enroll(int userID) {
        for (Student student : studentList) {
            if (student.getUserID()==userID) {
                this.studentList.add(student);
            }
        }
        System.out.println("Output from Course.Model.Course.enroll(): userID: " + userID);
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<TeachingTeam> getTeachingTeamList() {
        return teachingTeamList;
    }
}
