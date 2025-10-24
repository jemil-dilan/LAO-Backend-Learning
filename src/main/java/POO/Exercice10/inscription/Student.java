package inscription;

import java.util.HashSet;
import java.util.Set;

public class Student {
    
    private int studentNumber;
    private String name;
    private Set<Course> coursesWhereRegitered = new HashSet<Course>();

    public String getName() {
        return name;
    }
    
    public int getStudentNumber() {
        return studentNumber;
    }

    public Set<Course> getCoursesWhereRegistered() {
        return coursesWhereRegitered;
    }
    
    public void registerToCourse(Course course) {

        coursesWhereRegitered.add(course);
    }
    
    public void leaveTheCourse(Course course){
        
        coursesWhereRegitered.remove(course);
    }

}
