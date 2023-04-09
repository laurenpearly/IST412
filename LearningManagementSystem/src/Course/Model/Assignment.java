package Course.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Assignment implements NavigationTab {

    int assignmentID;
    String assignmentName;
    String assignmentDetails;
    int courseID;
    Date dueDate;
    Date todaysDate = Calendar.getInstance().getTime();
    ArrayList<Assignment> userAssignments = new ArrayList<>();

    /**
     * Constructor for Assignment object.
     * Gives an Assignment an ID, name, details, and assigns it to a course given an ID.
     * @param assignmentID The ID given to the new Assignment.
     * @param assignmentName Name given to the new Assignment.
     * @param assignmentDetails Details for the new Assignment.
     * @param courseID The ID of the Course the new Assignment is assigned to.
     */
    public Assignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID, Date dueDate) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.courseID = courseID;
        this.dueDate = dueDate;
    }

    public Assignment() {
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

    public Date getDueDate() { return dueDate; }

    public void todayAssignments(Date dueDate, ArrayList<Assignment> userAssignments){
        System.out.println("Entered TodaysAssignments in Course.Model.Assignment");

        ArrayList<String> currentAssignments = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDueDate = dateFormat.format(dueDate);
        String strTodaysDate = dateFormat.format(todaysDate);

        if(dueDate.equals(todaysDate)){
            currentAssignments.add(assignmentName);
            System.out.println("Today's Assignments: " + assignmentName);
        }
    }

    public void thisWeekAssignments(Date dueDate) throws ParseException {
        System.out.print("Entered ThisWeeksAssignments in Course.Model.Assignment");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        ArrayList<String> currentAssignments = new ArrayList<>();

        String strTodaysDate = dateFormat.format(todaysDate);
        todaysDate = dateFormat.parse(strTodaysDate);
        Calendar todaysDateCal = Calendar.getInstance();
        todaysDateCal.setTime(todaysDate);
        int todaysDateWeek = todaysDateCal.get(Calendar.WEEK_OF_YEAR);

        String strDueDate = dateFormat.format(dueDate);
        dueDate = dateFormat.parse(strDueDate);
        Calendar dueDateCal = Calendar.getInstance();
        dueDateCal.setTime(dueDate);
        int dueDateWeek = dueDateCal.get(Calendar.WEEK_OF_YEAR);

        if(todaysDateWeek == dueDateWeek)
        {
            currentAssignments.add(assignmentName);
            System.out.println("This Week's Assignments: " + assignmentName);
        }
    }

    public void allAssignments(){
        System.out.println("Entered allAssignments in Course.Model.Assignment");


        System.out.println("All Assignments: " + userAssignments);
    }

    public void display() {}

    public boolean isActive() {
        return false;
    }

}
