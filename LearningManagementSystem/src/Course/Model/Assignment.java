package Course.Model;

public class Assignment {

    int assignmentID;
    String assignmentName;
    String assignmentDetails;
    int courseID;

    /**
     * Constructor for Assignment object.
     * Gives an Assignment an ID, name, details, and assigns it to a course given an ID.
     * @param assignmentID The ID given to the new Assignment.
     * @param assignmentName Name given to the new Assignment.
     * @param assignmentDetails Details for the new Assignment.
     * @param courseID The ID of the Course the new Assignment is assigned to.
     */
    public Assignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.courseID = courseID;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public int getCourseID() {
        return courseID;
    }
}
