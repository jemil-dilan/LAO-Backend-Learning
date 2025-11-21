package POO_Collection_Optional.Exercise3.task;

public enum State {
    CANCELED(1) , FINISHED(2), ONGOING(3);
    int weight;

    State(Integer weight){this.weight = weight;}
}