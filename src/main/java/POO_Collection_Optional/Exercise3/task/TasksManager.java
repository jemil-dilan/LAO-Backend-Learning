package POO_Collection_Optional.Exercise3.task;

import java.util.*;

public class TasksManager {

    Queue<Task>  tasks;

    public TasksManager() {

        this.tasks = new PriorityQueue<Task>();
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

        Iterator<Task> taskIterator = tasks.iterator();

        while (taskIterator.hasNext()){

            Task task1 = taskIterator.next();
            if (Objects.equals(task1,task)){

                task1.setState(Task.State.CANCELED);
                tasks.remove(task1);
            }
        }
    }

    public Queue<Task> getTasks() {
        return tasks;
    }
}
