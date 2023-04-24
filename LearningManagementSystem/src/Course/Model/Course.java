package Course.Model;

import User.Model.Student.Student;
import User.Model.TeachingTeam.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;

public class Course extends Observable implements NavigationTab{
    int courseID;
    String courseName;
    ArrayList<Assignment> courseAssignments;
    String courseSubmissions;
    ArrayList<Student> studentList;
    ArrayList<TeachingTeam> teachingTeamList;
    ArrayList<Instructor> instructorList;
    ArrayList<GradeObserver> gradeObservers;
    Double grade;

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
        gradeObservers = new ArrayList<GradeObserver>();
    }

    public Course() {}

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

    public boolean writeCourse() {
        try(FileWriter fw = new FileWriter("src/Data/courseList.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(this.courseID + ":" + this.courseName);
            fw.append(System.lineSeparator());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    // Naming conventions are misleading - getScore() gets the assignemnts grade out of 100, while calculateGrade() returns a GPA-tailored calculation
    public Double getGrade(){
        Double total = 0.0;
        int counter = 0;
        for (Assignment asgn : courseAssignments) {
            total =+ asgn.getScore();
            counter ++;
        }
        total = total/counter;
        return total;
    }


    public void setGrade(Double grade){
        this.grade = grade;
        setChanged();
        notifyObservers();
    }

    public void addObserver(GradeObserver observer){
        gradeObservers.add(observer);
    }

    public void removeObserver(GradeObserver observer) {
        gradeObservers.remove(observer);
    }

    public void notifyGradeObservers(){
        for(GradeObserver observer : gradeObservers){
            observer.updateGrades();
        }
    }

    public void addTeachingTeam(TeachingTeam teachingTeam) {
        teachingTeamList.add(teachingTeam);
    }

    public ArrayList<TeachingTeam> getTeachingTeamList() {
        return teachingTeamList;
    }
    public void display(){}
    public boolean isActive(){
        return false;
    }
}
