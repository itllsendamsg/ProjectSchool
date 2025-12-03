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
    // lista studentów
    private final List<Student> students = new LinkedList<>();
    // mapa przedmiot - nauczyciel
    private final Map<Subject, Teacher> subjectTeacherMap = new HashMap<>();
    // dziennik
    private final Diary diary;
    // nazwa klasy, np. 1A, 2C, itd.
    private final String name;

    public SchoolClass(String name) {
        this.name = name;
        // tworzymy nowy dziennik
        this.diary = new Diary();
    }

    public void addStudent(Student student) {
        student.setSchoolClass(this);
        this.students.add(student);
    }

    // pobierz ucznia o danym imieniu
    public Student getStudent(String name) throws NoSuchStudentException {
        for (Student student : this.students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        throw new NoSuchStudentException("No such student in the class!");
    }

    // dodaj nauczyciela, który uczy danego przedmiotu
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
