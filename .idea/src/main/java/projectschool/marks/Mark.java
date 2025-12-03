package school.marks;

import school.people.Student;
import school.subjects.Subject;

import java.time.LocalDate;

/**
 * Konkretna ocena
 * Składają się na nią:
 *  - stopień
 *  - uczeń, który otrzymał ocenę
 *  - przedmiot, z którego wystawiono ocenę
 *  - data wystawienia oceny
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
