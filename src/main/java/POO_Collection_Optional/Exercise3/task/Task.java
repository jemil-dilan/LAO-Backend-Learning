package POO_Collection_Optional.Exercise3.task;

import java.time.LocalDateTime;

public class Task implements Comparable<Task>{

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

    @Override
    public String toString() {
        return "Task :" +
                "description='" + description +
                "  dueDate=" + dueDate +
                "  state=" + state +
                "\n";
    }

    @Override
    public int compareTo(Task other) {

        Integer orderThis = this.getState().weight;
        Integer orderOther = other.getState().weight;

        if (orderThis == null || orderOther == null) {
            return 0;
        }

        int stateComparison = orderThis.compareTo(orderOther);

        if (stateComparison == 0) {
            return this.dueDate.compareTo(other.getDueDate());
        }

        return stateComparison;
    }
}
