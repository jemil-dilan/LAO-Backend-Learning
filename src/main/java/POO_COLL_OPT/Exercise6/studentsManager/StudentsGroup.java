package POO_COLL_OPT.Exercise6.studentsManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentsGroup {

    List<Student> students;

    public StudentsGroup(List<Student> students) {
        this.students = new ArrayList<Student>(students);
    }

    public void addStudent(Student student){

        students.add(student);
    }

    public void removeStudent(Student student){

        students.remove(student);
    }

    public Optional<Student> studentWithBestNotes () {

        return  students.stream().filter(Objects::nonNull).reduce((student1, student2) ->  student1.getAverageNote() >= student2.getAverageNote() ? student1 : student2);
    }
}
