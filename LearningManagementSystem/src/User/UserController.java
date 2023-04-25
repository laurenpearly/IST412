package User;

import Course.CourseController;
import Data.Data;
import Message.MessageController;
import User.Model.User;

import javax.swing.*;

public class UserController {
    UserView userView;
    Data data;
    CourseController courseCtrl;
    MessageController messageCtrl;

    /**
     * Constructor for Controller
     */
    public UserController() {
        this.data = new Data();
        courseCtrl = data.getCourseCntl();
        messageCtrl = new MessageController();
        userView = new UserView(this);
    }

    /**
     * View user details.
     * @param user User being viewed.
     */
    public void viewUser(Data data, User user) {
        System.out.println("Passing through UserController.viewUser()...");
        userView.viewUser(data, user);
    }

    /**
     * View a user's courses.
     * @param user User whose courses are being viewed
     */
    public void viewCourses(User user, JFrame userFrame) {
        System.out.println("Passing through UserController.viewCourses()...");
        courseCtrl.viewCourses(data, user, userFrame);
    }

    /**
     * View a user's messages.
     * @param user User whose messages are being viewed.
     */
    public void viewMessages(User user) {
        System.out.println("Passing through UserController.viewMessages()...");
        userView.viewMessages(user.getUserID());
    }

    /**
     * Creates a course
     * @param userFrame to anchor other jframes
     */
    public void createCourse(Data data, JFrame userFrame) {
        courseCtrl.createCourse(data, userFrame);
    }
}
