package school.marks;

import school.people.Student;
import school.util.NoSuchStudentException;

import java.util.*;

/**
 * The Diary
 */
public class Diary {
    private final Map<Student, List<Mark>> studentMarksMap = new HashMap<>();

    // add a mark
    public void addMark(Mark mark) {
        List<Mark> marks = this.studentMarksMap.getOrDefault(mark.getStudent(), new LinkedList<>());
        marks.add(mark);
        this.studentMarksMap.put(mark.getStudent(), marks);
    }

    // get the grades of a student with a specific name
    public List<Mark> getMarks(String name) throws NoSuchStudentException {
        for (Map.Entry<Student, List<Mark>> entry : this.studentMarksMap.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return entry.getValue();
            }
        }
        throw new NoSuchStudentException("No such student in the diary");
    }
}
