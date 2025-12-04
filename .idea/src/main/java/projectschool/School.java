package school;

import school.people.Teacher;
import school.schoolclass.SchoolClass;
import school.util.NoSuchSchoolClassException;
import school.util.NoSuchTeacherException;
import school.util.SchoolClassAlreadyExistsException;
import school.util.TeacherAlreadyPresentException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class School {
    // the map of the classes in this specific school, the key is the name of a specific class
    private final Map<String, SchoolClass> schoolClasses = new HashMap<>();
    // school teachers
    private final Set<Teacher> teachers = new HashSet<>();
    private final String name;

    public School(String name) {
        this.name = name;
    }

    // add the class with a specific name
    public void addSchoolClass(String name) throws SchoolClassAlreadyExistsException {
        if (this.schoolClasses.containsKey(name)) {
            throw new SchoolClassAlreadyExistsException();
        }
        // we are adding the new class
        this.schoolClasses.put(name, new SchoolClass(name));
    }

    // get the class with a specific name
    public SchoolClass getSchoolClass(String name) throws NoSuchSchoolClassException {
        if (!this.schoolClasses.containsKey(name)) {
            throw new NoSuchSchoolClassException("There is no such school class in the school!");
        }
        return this.schoolClasses.get(name);
    }

    // add a teacher
    public void addTeacher(Teacher teacher) throws TeacherAlreadyPresentException {
        if (this.teachers.contains(teacher)) {
            throw new TeacherAlreadyPresentException();
        }
        this.teachers.add(teacher);
    }

    // get the teacher with a specific name
    public Teacher getTeacher(String name) throws NoSuchTeacherException {
        for (Teacher teacher : this.teachers) {
            if (teacher.getName().equals(name)) {
                return teacher;
            }
        }
        throw new NoSuchTeacherException("There is no such teacher in the school!");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SCHOOL: ").append(this.name).append("\n");
        stringBuilder.append("School classes:\n");
        for (SchoolClass schoolClass : this.schoolClasses.values()) {
            stringBuilder.append(schoolClass).append("\n");
        }
        stringBuilder.append("Teachers:\n");
        for (Teacher teacher : this.teachers) {
            stringBuilder.append(teacher).append("\n");
        }
        return stringBuilder.toString();
    }
}
