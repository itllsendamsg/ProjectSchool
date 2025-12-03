package school.people;

import school.schoolclass.SchoolClass;

public class Student extends Person {
    private SchoolClass schoolClass;

    public Student(String name, int age) {
        super(name, age);
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "Student: " + getName() + ", " + getAge() + " years old";
    }
}
