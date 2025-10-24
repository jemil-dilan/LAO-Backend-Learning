package student;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        
        List <Integer> notes = new ArrayList <Integer> ();

        notes.add(42);
        notes.add(2);
        notes.add(265);

        Student student = new Student("Blacky",0, notes);

        student.mention();
        System.out.println("Notes de l'étudiant " + student.getName() +
                            "\nMeilleure note " + student.getBestNote() +
                            "\nPire note " + student.getLowestNote());

        System.out.println(notes);

    }
}
