package POO_Collection_Optional.Exercise9.evaluation;

import java.util.HashMap;

public class Test {

    static void main(String[] args) {

        Evaluation evaluation1 =new Evaluation("Math", 6);
        Evaluation evaluation2 =new Evaluation("Physics", 4);
        Evaluation evaluation3 =new Evaluation("Phylo", 2);
        Evaluation evaluation4 =new Evaluation("Chim", 3);
        HashMap<Evaluation,Double> notes = new HashMap<Evaluation,Double>();
        notes.put(evaluation1, 0.25);
        notes.put(evaluation2, 1.0);
        notes.put(evaluation4, 2.75);

        Student toto = new Student("Toto jôn mangue", notes);
        evaluation3.setNote(18.0);
        toto.putEvaluationResult(evaluation3);

        toto.reEvaluate(evaluation2, 1.5);

        System.out.println("La note de toto en physics est : " + toto.getEvaluationNote(evaluation2));
        System.out.println("La moyenne de toto est : " + toto.calculateAverage(notes));
    }
}
