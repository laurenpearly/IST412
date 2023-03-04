package testharness;

import User.Model.Student.Student;

public class Main {
    /**
     * Start the program.
     * @param args main method
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //add tests here!!!
        studentTests();
    }

    public static void studentTests() {
        System.out.println("Output from studentTests(): Creating student...");
        Student student = new Student(0, "student", "password",
                "Erik", "Student");

    }
}