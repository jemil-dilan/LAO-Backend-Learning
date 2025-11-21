package POO_Collection_Optional.Exercise3.task;

import java.time.LocalDateTime;

public class Test {

    static void main(String[] args) {

        Task t1 = new Task("Laver les assiètes", LocalDateTime.of(2025, 3, 10, 14, 30));
        Task t2 = new Task("préparer le repas", LocalDateTime.of(2025, 3, 10, 15, 30));
        Task t3 = new Task("Dresser la table", LocalDateTime.of(2025, 3, 10, 18, 30));

        TasksManager tasksManager = new TasksManager();
        tasksManager.addTask(t2);
        tasksManager.addTask(t3);
        tasksManager.addTask(t1);

//        tasksManager.cancelTask(t3);
//        tasksManager.finishTask(t1);

        while (!tasksManager.getTasks().isEmpty()){

            System.out.println(tasksManager.getTasks().poll());
        }
    }
}
