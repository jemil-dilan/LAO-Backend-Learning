package POO_Collection_Optional.Exercise4.messenger;

public class Member {

    private String userName;
    private int userPhone;

    public Member(String userName, int userPhone) {
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public Message createMessage(String messageContent){

        return new Message(messageContent, this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", userPhone=" + userPhone +
                '}';
    }
}
