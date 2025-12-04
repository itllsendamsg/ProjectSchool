package school.util;

public class TeacherAlreadyPresentException extends Exception {
    public TeacherAlreadyPresentException() {
        super("Such a teacher is already present in the school!");
    }
}
