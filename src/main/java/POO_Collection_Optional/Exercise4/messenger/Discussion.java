package POO_Collection_Optional.Exercise4.messenger;

import java.util.LinkedList;
import java.util.List;

public class Discussion {

    private List<Message> discussionFlow;

    public Discussion() {
        this.discussionFlow = new LinkedList<>();
    }

    public void display(){

        discussionFlow.forEach(
            message -> {
                System.out.println(message);
                message.setStatus(Message.Status.READ);
            }
        );
    }

    public void displayNotifications(){

        discussionFlow.reversed().stream().filter(message -> message.getStatus() == Message.Status.UNREAD).limit(3).forEach(System.out::println);
    }

    public void addMessage(Message message){

        discussionFlow.addLast(message);
        message.setStatus(Message.Status.UNREAD);
    }

    public void deleteMessage(Message message){

        discussionFlow.remove(message);
        message.setStatus(Message.Status.DELETED);
    }

}
