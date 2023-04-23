package Course.Model;

import Course.CourseController;
import User.Model.User;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Assignment implements NavigationTab {

    private GradingStrategy gradingStrategy;
    int assignmentID;
    String assignmentName;
    String assignmentDetails;
    int courseID;
    double score;
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
        this.score = score;
    }

    public Assignment(int assignmentID, String assignmentName, String assignmentDetails, int courseID) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.assignmentDetails = assignmentDetails;
        this.courseID = courseID;
    }

    public Assignment() {
    }

    public boolean submitAssignment(CourseController courseCntl, User user, String submission) {
        try(FileWriter fw = new FileWriter("src/Data/submissionList.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(user.getUserID() + ":" + this.getAssignmentID() + ":" + submission);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean gradeAssignment(CourseController courseCntl, User user, Double grade) {
        try (FileWriter fw = new FileWriter("LearningManagementSystem/src/Data/gradedList.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getUserID() + ":" + this.getAssignmentID() + ":" + grade);
            return true;
        } catch (IOException e) {
            return false;
        }
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

    public void setGradingStrategy(GradingStrategy strategy) {
        this.gradingStrategy = strategy;
    }

    public double calculateGrade() {
        return gradingStrategy.calculateGrade(this);
    }


    public double getScore() {
        return score;
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
