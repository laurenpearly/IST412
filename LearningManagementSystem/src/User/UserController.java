package User;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import Data.Data;
import Message.MessageController;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;
import User.Model.User;

import java.util.ArrayList;

public class UserController {
    UserView userView;
    Data data;
    CourseController courseCtrl;
    MessageController messageCtrl;
    ArrayList<Student> studentList;

    /**
     * Constructor for Controller
     */
    public UserController() {
        this.data = new Data();
        courseCtrl = data.getCourseCntl();
        messageCtrl = new MessageController();
        userView = new UserView(this);
        studentList = new ArrayList<Student>();
    }

    /**
     * View user details.
     * @param user User being viewed.
     */
    public void viewUser(User user) {
        System.out.println("Passing through UserController.viewUser()...");
        userView.viewUser(user);
    }

    /**
     * View a user's courses.
     * @param user User whose courses are being viewed
     */
    public ArrayList<Course> viewCourses(User user) {
        System.out.println("Passing through UserController.viewCourses()...");
        ArrayList<Course> courses = new ArrayList<>(courseCtrl.getCourses(user.getUserCourses()));
        return courses;
    }

    /**
     * View assignments for a course.
     * @param courseID Course whose assignments are being viewed.
     */
    public ArrayList<Assignment> viewAssignments(int courseID) {
        System.out.println("Passing through UserController.viewAssignments()...");
        ArrayList<Assignment> assignments = new ArrayList<>(courseCtrl.getAssignments(courseID));
        return assignments;
    }

    /**
     * View a user's messages.
     * @param user User whose messages are being viewed.
     */
    public void viewMessages(User user) {
        System.out.println("Passing through UserController.viewMessages()...");
        userView.viewMessages(user.getUserID());
    }

    /**
     * User logs in.
     * @param userLoginName Username.
     * @param userPassword Password.
     */
    public void logIn(String userLoginName, String userPassword) {
        System.out.println("Passing through UserController.logIn()...");
        //authCtrl.authenticate(userLoginName, userPassword);
    }

    /**
     * Enroll in a course
     * @param student Student to enroll
     * @param courseID ID of course to enroll in
     */
    public void enroll(Student student, int courseID) {
        System.out.println("Passing through UserController.enroll()...");
        student.enroll(courseID);
        courseCtrl.enroll(student.getUserID(), courseID);
    }

    /**
     * Submit an assignment to a course
     * @param student Student who is submitting
     * @param courseID Course being submitted to
     * @param assignmentID Assignment being submitted
     * @param courseSubmission Submission
     */
    public void submitAssignment(Student student, int courseID, int assignmentID, String courseSubmission) {
        System.out.println("Passing through User.UserController.submitAssignment()...");
        student.submitAssignment(assignmentID, courseSubmission);
        courseCtrl.submitAssignment(student.getUserID(), courseID, assignmentID, courseSubmission);
    }

    /**
     * View grades
     * @param student Student whose grades are being viewed
     */
    public void viewGrades(Student student) {
        System.out.println("Passing through User.UserController.viewGrades()...");
        //userView.viewGrades(student.getUserID(), student.getUserCourses(), student.getGrades());
    }

    /**
     * Used to assign a user to teach a course
     * @param teachingTeam TeachingTeam person teaching the course
     * @param courseID ID of course to be taught
     */
    public void teachCourse(TeachingTeam teachingTeam, int courseID) {
        System.out.println("Passing through User.UserController.teachCourse()...");
        teachingTeam.teachCourse(courseID);
    }

    /**
     * Grade assignments for a course
     * @param teachingTeam User that is the grader
     * @param courseID ID of course to grade
     * @param assignmentID Assignment being graded
     */
    public void gradeAssignment(TeachingTeam teachingTeam, int courseID, int assignmentID) {
        System.out.println("Passing through User.UserController.gradeAssignment()...");
        teachingTeam.gradeAssignment(courseID, assignmentID);
    }

    /**
     * Creates a course
     * @param instructor Instructor creating the course
     * @param course Course being made
     */
    public void createCourse(Instructor instructor, Course course) {
        System.out.println("Passing through User.UserController.createCourse()...");
        instructor.createCourse(course);
    }

    /**
     * Creates an assignment for a course
     * @param instructor Instructor creating the assignment
     * @param assignment Assignment being made
     */
    public void createAssignment(Instructor instructor, Assignment assignment) {
        System.out.println("Passing through User.UserController.createAssignment()...");
        instructor.createAssignment(assignment);
    }
}
