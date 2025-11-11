package POO_Collection_Optional.Exercise4.messenger;

import java.time.LocalDateTime;

public class Message {

    public enum Status {UNREAD, READ, DELETED}

    private User author;
    private String messageContent;
    private LocalDateTime messageDateAndTime;
    private Status status;

    public Message(String messageContent) {
        this.messageContent = messageContent;
        this.messageDateAndTime = LocalDateTime.now();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "|author=" + author +
                "|\n----------------------------------------------" +
                "\n|messageContent='" + messageContent + '\'' +
                "|\n----------------------------------------------" +
                "\n|messageDateAndTime=" + messageDateAndTime +
                "|\n----------------------------------------------" ;
    }
}
