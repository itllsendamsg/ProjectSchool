package school.util;

public class SchoolClassAlreadyExistsException extends Exception {
    public SchoolClassAlreadyExistsException() {
        super("Such school class already exists in the school!");
    }
}
