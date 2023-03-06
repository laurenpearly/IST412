package Message;

import User.Model.User;

public class MessageView {
    String messageContent;
    User sender;
    User receiver;

    /**
     * Constructor for View.
     */
    public MessageView() {

    }

    /**
     * Send a message to another user.
     * @param messageContent Content of message.
     * @param sender Sender of message.
     * @param receiver Receiver of message.
     */
    public void sendMessage(String messageContent, User sender, User receiver) {
        System.out.println("Message: " + messageContent);
        System.out.println("From: " + sender.getUserFirstName());
        System.out.println("To: " + receiver.getUserFirstName());
    }

    /**
     * Read a message.
     * @param messageContent Content of message.
     * @param sender Sender of message.
     */
    public void viewMessage(String messageContent, User sender) {
        System.out.println("Message: " + messageContent);
        System.out.println("From: " + sender.getUserFirstName());
    }
}
