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

    /**
     * Given the assignment ID, shows the name, details, and ID of the course it is assigned to.
     * @param assignmentID The ID given to the Assignment.
     * @param assignmentName Name given to the Assignment.
     * @param assignmentDetails Details for the Assignment.
     * @param courseID The ID of the Course the Assignment is assigned to.
     */
    public void viewAssignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {

    }
}
