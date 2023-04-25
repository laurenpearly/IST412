package Data;

import Course.CourseController;
import Course.Model.Assignment;
import Course.Model.Course;
import Message.Model.Message;
import User.Model.Student.Student;
import User.Model.TeachingTeam.Instructor;
import User.Model.TeachingTeam.TeachingTeam;

import java.io.BufferedReader;
import java.io.FileReader;

public class Data {

    CourseController courseCntl;
    TeachingTeam teachingTeam;
    Instructor instructor;
    Student student;
    Message message;

    public Data() {
        courseCntl = new CourseController();
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
        instructor.addUserCourses(24);
        instructor.addUserCourses(44);
        instructor.addUserCourses(33);
        teachingTeam.addUserCourses(24);
        teachingTeam.addUserCourses(33);
    }

    public void createCourseObjects() {
        final String FILENAME = "LearningManagementSystem/src/Data/courseList.txt";
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

    public void createAssignmentObjects() {
        final String FILENAME = "LearningManagementSystem/src/Data/assignmentList.txt";
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

    /*private void createGradedAssignmentObjects() {
        final String FILENAME = "LearningManagementSystem/src/Data/gradedList.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] gradedAssignment = line.split(":");
                Assignment assignmentObj = new Assignment(Integer.parseInt(gradedAssignment[0]),gradedAssignment[1],
                        gradedAssignment[2],Integer.parseInt(gradedAssignment[3]));
                courseCntl.addAssignment(assignmentObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

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