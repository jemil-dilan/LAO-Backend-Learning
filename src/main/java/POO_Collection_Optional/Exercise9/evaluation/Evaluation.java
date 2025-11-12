package POO_Collection_Optional.Exercise9.evaluation;

public class Evaluation {

    private String subject;
    private Double note;
    private int coefficient;

    public Evaluation(String subject, int coefficient) {
        this.subject = subject;
        this.coefficient = coefficient;
    }

    public Double getNote() {
        return note;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
