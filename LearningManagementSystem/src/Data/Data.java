package Data;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;
import User.UserController;
import Message.Model.Message;

import java.util.Date;

public class Data {

    Course course;
    Date dueDate;
    Assignment assignment;
    TeachingTeam teachingTeam;
    Instructor instructor;
    Student student;
    Message message;

    public Data() {
        course = new Course(24, "TestCourse");
        dueDate = new Date(2023, 3, 9);
        assignment = new Assignment(28, "testAssignment", "details", 24, dueDate);
        teachingTeam = new TeachingTeam(1, 1, "team", "team",
                "Sara", "TeachTeam");
        instructor = new Instructor(2, 2, "instructor", "teach",
                "John", "Instructor");
        student = new Student(0, 0, "student",
                "stu", "Erik", "Student");
        message = new Message("Test message", student, instructor);

        course.getTeachingTeamList().add(teachingTeam);
        course.getTeachingTeamList().add(instructor);
        student.getUserCourses().add(24);
        student.getUserCourses().add(33);
    }

    public Student getStudent() {
        return student;
    }

    public TeachingTeam getTeachingTeam() {
        return teachingTeam;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public static void data() {
        //dummy data for tests


        //controllers to call from tests here
        CourseController corsCtrl = new CourseController();
        UserController userCtrl = new UserController();
        //AuthController authCtrl = new AuthController();

        //corsCtrl.addCourses(course);

    }
}