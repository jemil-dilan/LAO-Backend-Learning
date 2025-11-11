package POO_Collection_Optional.Exercise3.task;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class TasksManager {

    Queue<Task>  tasks;

    public TasksManager() {
        this.tasks = new PriorityQueue<>(Comparator.comparing(Task::getState).thenComparing(Task::getDueDate));
    }

    public void addTask(Task task){

        task.setState(Task.State.ONGOING);
        tasks.offer(task);
    }

    public void finishTask(Task task){

        if (Objects.equals(tasks.peek(), task)){

            task.setState(Task.State.FINISHED);
            tasks.poll();
        }
    }

    public void cancelTask (Task task) {

        tasks.forEach(task1 -> {
            if (Objects.equals(task1,task)){

                task1.setState(Task.State.CANCELED);
                tasks.poll();
            }
        });
    }
}
