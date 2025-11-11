package POO_Collection_Optional.Exercise4.messenger;

public class User {

    private String userName;
    private int userPhone;

    public User(String userName, int userPhone) {
        this.userName = userName;
        this.userPhone = userPhone;
    }

    private void sendMessage(Discussion discussion, String messageContent){

        discussion.addMessage(new Message(messageContent));
    }

    private void deleteMessage(Discussion discussion,Message message){

        discussion.deleteMessage(message);
    }
}
