package school.people;

import school.marks.Grade;
import school.marks.Mark;
import school.schoolclass.SchoolClass;
import school.subjects.Subject;
import school.util.NoSuchStudentException;

import java.time.LocalDate;

public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    // dodaj nową ocenę z przedmiotu subject studentowi o danym imieniu
    public void addMark(Grade grade, Subject subject, String name, SchoolClass schoolClass) throws NoSuchStudentException {
        Student student = schoolClass.getStudent(name);
        Mark mark = new Mark(grade, student, subject, LocalDate.now());
        // weź dziennik
        schoolClass.getDiary().addMark(mark);
    }

    @Override
    public String toString() {
        return "Teacher: " + getName() + ", " + getAge() + " years old";
    }
}
