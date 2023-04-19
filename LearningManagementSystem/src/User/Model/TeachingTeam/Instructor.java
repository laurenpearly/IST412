package User.Model.TeachingTeam;

import Course.Model.Assignment;
import Course.Model.Course;

public class Instructor extends TeachingTeam {

    /**
     * Constructor for teaching team
     * @param userID Teaching team ID
     * @param userLoginName Teaching team Username
     * @param userPassword Teaching team Password
     * @param userFirstName Teaching team first name
     * @param userLastName Teaching team last name
     */
    public Instructor(int userID, int userType, String userLoginName, String userPassword, String userFirstName, String userLastName) {
        super(userID, userType, userLoginName, userPassword, userFirstName, userLastName);
    }

    /**
     * Creates a course
     * @param course Course to be made
     */
    public void createCourse(Course course) {
        System.out.println("Output from User.Model.TeachingTeam.Instructor.createCourse(): courseName: " +
                course.getCourseName());
    }

    /**
     * Creates an assignment for a course
     * @param assignment Assignment being made
     */
    public void createAssignment(Assignment assignment) {
        System.out.println("Output from User.Model.TeachingTeam.Instructor.createAssignment(): courseID: " +
                assignment.getCourseID() + " assignmentName: " + assignment.getAssignmentName());
    }
}
