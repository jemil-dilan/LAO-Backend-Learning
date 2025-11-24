package POO_Collection_Optional.Exercise4.messenger;

import java.time.LocalDateTime;

public class Message {

    public enum Status {UNREAD, READ, DELETED}

    private Member author;
    private String messageContent;
    private LocalDateTime messageDateAndTime;
    private Status status;

    public Message(String messageContent, Member author) {

        this.author = author;
        this.messageContent = messageContent;
        this.messageDateAndTime = LocalDateTime.now();
        this.status = Status.UNREAD;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Member getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "|author=" + author +
                "|\n----------------------------------------------" +
                "\n|messageContent='" + messageContent + '\'' + " \n|messageDateAndTime=" + messageDateAndTime +
                "|\n----------------------------------------------" + "| ---------------------------------------------- \n" ;
    }
}
