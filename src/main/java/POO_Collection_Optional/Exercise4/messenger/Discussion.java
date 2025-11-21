package POO_Collection_Optional.Exercise4.messenger;

import java.util.*;

public class Discussion {

    private List<Message> discussionFlow;
    private Set<Member> members;

    public Discussion(Set<Member> members) {

        this.discussionFlow = new ArrayList<>();
        this.members = new HashSet<>(members);
    }

    public void display(){

        discussionFlow.forEach(
            message -> {
                System.out.println(message);
                message.setStatus(Message.Status.READ);
            }
        );
    }

    private void sendMessage(Message message){

        if (members.contains(message.getAuthor())){

            discussionFlow.add(message);
            message.setStatus(Message.Status.UNREAD);
        }
    }

    public void deleteMessage(Message message){

        if (members.contains(message.getAuthor())){

            discussionFlow.remove(message);
            message.setStatus(Message.Status.DELETED);
        }
    }

    public void displayNotifications(){

        discussionFlow.reversed().stream().filter(message -> message.getStatus() == Message.Status.UNREAD).limit(3).forEach(System.out::println);
    }

}
