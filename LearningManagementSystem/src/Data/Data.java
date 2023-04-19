package Data;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import Message.MessageController;
import Message.Model.Message;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;

import java.io.BufferedReader;
import java.io.FileReader;

public class Data {

    CourseController courseCntl;
    MessageController messageCntl;
    TeachingTeam teachingTeam;
    Instructor instructor;
    Student student;
    Message message;

    public Data() {
        courseCntl = new CourseController();
        messageCntl = new MessageController();
        createCourseObjects();
        createAssignmentObjects();

        teachingTeam = new TeachingTeam(1, 1, "team", "team",
                "Sara", "TeachTeam");
        instructor = new Instructor(2, 2, "instructor", "teach",
                "John", "Instructor");
        student = new Student(0, 0, "student",
                "stu", "Erik", "Student");
        message = new Message("Test message", student, instructor);

        student.addUserCourses(24);
        student.addUserCourses(33);
        //FIXcourse.getTeachingTeamList().add(teachingTeam);
        //FIXcourse.getTeachingTeamList().add(instructor);
    }

    private void createCourseObjects() {
        final String FILENAME = "src/Data/courseList.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] course = line.split(":");
                Course courseObj = new Course(Integer.parseInt(course[0]),course[1]);
                courseCntl.addCourse(courseObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAssignmentObjects() {
        final String FILENAME = "src/Data/assignmentList.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] assignment = line.split(":");
                Assignment assignmentObj = new Assignment(Integer.parseInt(assignment[0]),assignment[1],
                        assignment[2],Integer.parseInt(assignment[3]));
                courseCntl.addAssignment(assignmentObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public CourseController getCourseCntl() {
        return courseCntl;
    }

}