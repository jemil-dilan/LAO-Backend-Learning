package POO_Collection_Optional.Exercise3.task;

import java.time.LocalDateTime;

public class Task {

    public enum State {CANCELED , FINISHED, ONGOING}

    private String description;
    private LocalDateTime dueDate;
    private State state;

    public Task(String description, LocalDateTime dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
