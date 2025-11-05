package student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int studentNumber;
    private List<Integer> notes = new ArrayList<Integer>();



    public Student(String name, int studentNumber, List<Integer> notes){

        this.name = name;
        this.studentNumber = studentNumber;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void addNote(Integer note){
        if (note >= 0 && note <= 100) {

            notes.add(note);
        } else {
            System.out.println("Entrez une note valide");
        }
    }

    public double getAverage(){

        double totalOfNotes = 0;
        for (Integer note : this.notes) {

            totalOfNotes = totalOfNotes + note;
        }
        return totalOfNotes/this.notes.size();
    }

    public int getBestNote(){

        int bestNote = 0;
        for (Integer note : this.notes) {
    
            bestNote = Math.max(bestNote, note);
        }
        return bestNote;
    }

    public int getLowestNote(){

        int lowestNote = 100;
        for (Integer note : this.notes) {

            lowestNote = Math.min(lowestNote, note);
        }
        return lowestNote;
    }

    public void mention(){

        if (getAverage()>= 90) {
            System.out.println("L\'étudiant n° " + this.studentNumber +" " + this.name +" reçoit la mention A");
        } else if (getAverage()>= 80) {
            System.out.println("L\'étudiant n° " + this.studentNumber +" " + this.name +" reçoit la mention B");
        } else if (getAverage()>= 70) {
            System.out.println("L\'étudiant n° " + this.studentNumber +" " + this.name +" reçoit la mention C");
        } else {
            System.out.println("L\'étudiant n° " + this.studentNumber +" " + this.name +" reçoit la mention D");
        }    
    }
}