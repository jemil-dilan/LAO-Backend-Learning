package inscription;

import java.util.*;

public class University {
    
    private Set<Student> studentsRegistered = new HashSet<Student>();
    private List<Course> differentsCourses = new ArrayList<Course>();

    public void displaySomeCourse(String courseCode){

        for (Course course : differentsCourses) {

            if (Objects.equals(course.getCourseCode(), courseCode)){
                course.displayCourseInformations();
                break;
            }
        }
    }
}
