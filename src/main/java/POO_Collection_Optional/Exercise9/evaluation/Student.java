package POO_Collection_Optional.Exercise9.evaluation;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Student {

    private String name;
    private Set<Evaluation> evaluations;

    public Student(String name, Set<Evaluation> evaluations) {
        this.name = name;
        this.evaluations = new HashSet<>(evaluations);
    }

    private void getEvaluationResult(Evaluation evaluation){

        evaluations.add(evaluation);
    }

    private double calculateAverage(Set<Evaluation> evaluations) {

        double sumOfNotesTimesCoefficient = 0;
        int sumOfCoefficients = 0;

        for (Evaluation evaluation : evaluations) {
            Optional<Double> note = Optional.ofNullable(evaluation.getNote());
            sumOfNotesTimesCoefficient += note.orElse(0.0) * evaluation.getCoefficient();
            sumOfCoefficients += note.orElse(0.0);
        }

        return sumOfCoefficients == 0 ? 0 : sumOfNotesTimesCoefficient / sumOfCoefficients;
    }

}
