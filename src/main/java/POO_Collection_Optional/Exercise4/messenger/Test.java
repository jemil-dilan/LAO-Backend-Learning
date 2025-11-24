package POO_Collection_Optional.Exercise4.messenger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    static void main(String[] args) {

        Member member1 = new Member("Adon La peinture", 657455908);
        Member member2 = new Member("Mr Londô Brad", 675505025);

        Set<Member> members = new HashSet<Member>();
        members.add(member1);
        members.add(member2);

        Message message1 = member1.createMessage("Bonjour la team le picasso est dans la place");
        Message message2 = member1.createMessage("ça va aller??? Le niveau est bon? Si ça va pas y'a le renfort hein");
        Message message3 = member2.createMessage("Mon bon petit qu'est ce qui te met la joie comme ça?");
        Message message4 = member1.createMessage("Les gars c'est le ndem faut pas écouter ses histoire là. Humm?? Les histoires de qui?");

        List<Message> messages = new ArrayList<Message>();
        messages.add(message1);
        messages.add(message2);

        Discussion laoBackend = new Discussion(members);
        laoBackend.setDiscussionFlow(messages);
//        laoBackend.deleteMessage(message2);
        laoBackend.display();

        laoBackend.sendMessage(message3);
        laoBackend.sendMessage(message4);
        laoBackend.displayNotifications();

    }
}
