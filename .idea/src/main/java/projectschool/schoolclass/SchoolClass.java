package school.schoolclass;

import school.marks.Diary;
import school.people.Student;
import school.people.Teacher;
import school.subjects.Subject;
import school.util.NoSuchStudentException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Klasa
 */
public final class SchoolClass {
    // the list of students
    private final List<Student> students = new LinkedList<>();
    // the map subject - teacher
    private final Map<Subject, Teacher> subjectTeacherMap = new HashMap<>();
    // the diary
    private final Diary diary;
    // class name, i.e. 1A, 2C, and so on.
    private final String name;

    public SchoolClass(String name) {
        this.name = name;
        // the new diary is created
        this.diary = new Diary();
    }

    public void addStudent(Student student) {
        student.setSchoolClass(this);
        this.students.add(student);
    }

    // get the student with a provided name
    public Student getStudent(String name) throws NoSuchStudentException {
        for (Student student : this.students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new NoSuchStudentException("No such student in the class!");
    }

    // add the teacher who teaches the specific subject
    public void addTeacher(Teacher teacher, Subject subject) {
        this.subjectTeacherMap.put(subject, teacher);
    }

    public Diary getDiary() {
        return diary;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("School class: ").append(this.name);
        stringBuilder.append(", students: ");
        for (Student student : this.students) {
            stringBuilder.append(student).append("; ");
        }
        return stringBuilder.toString();
    }
}
