package Message.Model;

import User.Model.User;

public class Message {
    String messageContent;
    User sender;
    User receiver;

    /**
     * Constructor for new Message object.
     * @param messageContent Content of message.
     * @param sender Sender of message.
     * @param receiver Receiver of message.
     */
    public Message(String messageContent, User sender, User receiver) {

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
