package Course.View;

import Course.Model.Course;
import Course.Model.GradeObserver;
import User.UserView;

public class GradeView implements GradeObserver {
    UserView userView;
    Course course;

    public GradeView(UserView userView, Course course){
        this.userView = userView;
        this.course = course;
        course.addObserver(this);
    }

    public void updateGrades(){
        userView.viewGrade(course.getCourseName(), course.getGrade());
    }
}
