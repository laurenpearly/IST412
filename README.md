# IST412 - LMS
Erik - erg5272  
Tom - tan5187  
Lauren - lmp5874  
Zac - zmh5199
Logan - ljk5424

## Logins

- **Student:** username: student, password: stu
- **Teaching Team:** username: team, password: team
- **Instructor:** username: instructor, password: teach

## M04-A03 - Two Implemented Use Cases with Clean, Refactored Code

### Refactoring Plan Implementations

#### Erik:

- **testharness.Main:** Deleted commented code. Moved Main method to start program out into root directory.
- **Data.Data:** Repurposed testharness into Data package and class, loads persistent data from text files(database) for use in the program.
- **Authentication.Model.Authentication:** Split code from AuthView and put here to make it useful again (was Dead Code code smell).
- **Authentication.AuthController:** Split code from AuthView and put here to make it useful again (was Speculative Generality code smell).
- **Authentication.AuthView:** UserSignInGUI is now AuthView, and code has been split between this class, Authentication, and AuthController to make class smaller.
- **User.UserController.createAssignment():** Shortened parameter list by passing Assignment object instead of individual attributes.
- **User.UserController.createCourse():** Shortened parameter list by passing Course object instead of individual attributes.
- **User.UserView:** Moved some code to CourseController and CourseView to make class smaller.
- **User.UserController.viewAssignment():** Removed because no longer needed, eliminating the message chain.
- **NOTE:** User.UserController.viewCourses() still includes a small message chain, because objects needed to get passed from UserView to CourseView and there was no way to make it more concise.

## IDEs and Use Case Implementations

Lauren:
  - IDE: InteliJ with version control using GitHub
  - implemented the grade use case which allows assignments to be graded and updated for users to view and staff to edit/add
Zac:
  - IDE: InteliJ
  - Implemented the grade assignments use case.
Logan:
  - IDE: VSCode
  - Completed the unfinished and then polished both grading assignment and submit assignment use cases.
Tom:
  - IDE: VSCode
  - Finalized authentication use case, helped implement functionality to the course class(es) and added additional grading logic.

## Design Patterns

### Object-Oriented Design Patterns

- **Erik - Singleton:** Implemented in the Authentication model class to ensure only one Authenticate object is used in the program.
- **Lauren - Observer:** Implemented in the Course class to create a grade observer to allow changes to grades to be updated automattically throughout
- **Tom - Strategy:** Implemented in the Assignment class to allow different grading criteria and strategies such as Pass/Fail or Percentage.
- **Logan - Composite Structure:** Implemented in the assignment and course classes to dynamically calculate grade and score at the course level.
- **Zac - Iterator:** Implemented in the Assignment class to allow users to view assignments by today, this week, next week, and all assignments

### User Interface Design Patterns

- **Erik - Alternating Row Colors:** Implemented in the UserView class to display assignments in a table.
- **Lauren - Navigation Tabs:** Implemented in the Course, Assignment and Message classes and allows users to see their current active screen
- **Logan - Notifications:** Notifies the user when an event occurs
- **Tom - Password Strength Meters:** A meter in the UserSigninGUI which automatically ticks up as new data is being entered into the password textbox, informing new users of their prospective password strength, and giving present users a reminder of their potential password weakness.
- **Zac - Calendar Picker:** Implemented in the Assignment class to allow users to view assignments by date
