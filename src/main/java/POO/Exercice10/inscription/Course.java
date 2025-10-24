package inscription;

import java.util.HashSet;
import java.util.Set;

public class Course {
    
    private int courseCode;
    private String courseName;
    private String professor;
    private int maximumCapacity;
    private Set<Student> studentRegistered = new HashSet<Student>();

    public Course(int courseCode, String courseName, String professor, int maximumCapacity, Set<Student> studentRegistered){

        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.maximumCapacity = Math.max(maximumCapacity, 5);
        this.studentRegistered = studentRegistered;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public Set<Student> getStudentRegistered() {
        return studentRegistered;
    }

    public void setStudentRegistered(Set<Student> studentRegistered) {
        this.studentRegistered = studentRegistered;
    }

    public void addStudent(Student student){
    
        if (maximumCapacity < studentRegistered.size()) {
            
            studentRegistered.add(student);
        } else {
            
            System.out.println("Le nombre maximal d\'étudiant a été atteind pour ce cours");
        }
        
    }
}
