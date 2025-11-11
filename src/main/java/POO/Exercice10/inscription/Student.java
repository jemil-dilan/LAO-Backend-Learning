package POO.Exercice10.inscription;

import java.util.HashSet;
import java.util.Set;

public class Student {
    
    private int studentNumber;
    private String name;
    private Set<Course> coursesWhereRegitered = new HashSet<Course>();

    public Student(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCoursesWhereRegistered() {
        return coursesWhereRegitered;
    }
    
    public void registerToCourse(Course course) {

        coursesWhereRegitered.add(course);
    }
    
    public void leaveTheCourse(Course course){
        
        coursesWhereRegitered.remove(course);
        course.removeStudent(this);
    }

}
