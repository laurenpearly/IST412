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

    }

    /**
     * Read a message.
     * @param messageContent Content of message.
     * @param sender Sender of message.
     */
    public void viewMessage(String messageContent, User sender) {

    }
}
