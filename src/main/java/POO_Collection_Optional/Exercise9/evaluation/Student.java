package POO_Collection_Optional.Exercise9.evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Student {

    private String name;
    private Map<Evaluation, Double> evaluationsNotes;

    public Student(String name, HashMap<Evaluation, Double> evaluationsNotes) {
        this.name = name;
        this.evaluationsNotes = new HashMap<>(evaluationsNotes);
    }

    private void getEvaluationResult(Evaluation evaluation){

        evaluationsNotes.put(evaluation, evaluation.getNote());
    }

    private double calculateAverage(HashMap<Evaluation, Double> evaluationsNotes) {

        double sumOfNotesTimesCoefficient = 0;
        int sumOfCoefficients = 0;

        for (Map.Entry<Evaluation, Double> evaluationNote : evaluationsNotes.entrySet()) {

            Optional<Double> note = Optional.ofNullable(evaluationNote.getValue());

            sumOfNotesTimesCoefficient += note.orElse(0.0) * evaluationNote.getKey().getCoefficient();
            sumOfCoefficients += note.orElse(0.0);
        }

        return sumOfCoefficients == 0 ? 0 : sumOfNotesTimesCoefficient / sumOfCoefficients;
    }

    public Optional<Double> getEvaluationNote(Evaluation evaluation){

        return Optional.ofNullable(evaluationsNotes.get(evaluation));
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEvaluationsNotes(Map<Evaluation, Double> evaluationsNotes) {
        this.evaluationsNotes = evaluationsNotes;
    }
}
