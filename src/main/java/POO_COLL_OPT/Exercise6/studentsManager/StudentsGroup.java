package POO_COLL_OPT.Exercise6.studentsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentsGroup {

    List<Employee> students;

    public StudentsGroup(List<Employee> students) {
        this.students = new ArrayList<Employee>(students);
    }

    public void addStudent(Employee student){

        students.add(student);
    }

    public void removeStudent(Employee student){

        students.remove(student);
    }

    public Optional<Employee> studentWithBestNotes () {

        return  students.stream().filter(Objects::nonNull).reduce((student1, student2) ->  student1.getAverageNote() >= student2.getAverageNote() ? student1 : student2);
    }
}
