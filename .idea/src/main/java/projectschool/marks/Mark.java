package school.marks;

import school.people.Student;
import school.subjects.Subject;

import java.time.LocalDate;

/**
 * Specific grade
 * It encompases:
 *  - the grade
 *  - the student who got this grade
 *  - the subject for the given grade
 *  - the date of the given grade
 */
public final class Mark {
    private final Grade grade;
    private final Student student;
    private final Subject subject;
    private final LocalDate date;

    public Mark(Grade grade, Student student, Subject subject, LocalDate date) {
        this.grade = grade;
        this.student = student;
        this.subject = subject;
        this.date = date;
    }

    public Grade getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "grade=" + grade +
                ", student=" + student +
                ", subject=" + subject +
                ", date=" + date +
                '}';
    }
}
