package POO_COLL_OPT.Exercise6.studentsManager;

public class Student {

    private String name;
    private int age;
    private double averageNote;


    public Student(String name, int age, double averageNote) {
        this.name = name;
        this.age = age;
        this.averageNote = averageNote;
    }

    public String getName() {
        return name;
    }

    public double getAverageNote() {
        return averageNote;
    }
}
