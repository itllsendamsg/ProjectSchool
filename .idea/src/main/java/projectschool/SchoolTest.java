package school;

import school.marks.Grade;
import school.marks.Mark;
import school.people.Student;
import school.people.Teacher;
import school.schoolclass.SchoolClass;
import school.subjects.Subject;
import school.util.*;

import java.util.List;

public class SchoolTest {
    public static void addSchoolClasses(School school) throws SchoolClassAlreadyExistsException {
        school.addSchoolClass("1A");
        school.addSchoolClass("2C");
    }

    public static void addTeachers(School school) throws TeacherAlreadyPresentException {
        Teacher williamShakespeare = new Teacher("William Shakespeare", 45);
        Teacher adamMickiewicz = new Teacher("Adam Mickiewicz", 53);
        Teacher stefanBanach = new Teacher("Stefan Banach", 62);
        Teacher boguslawWoloszanski = new Teacher("Bogusław Wołoszański", 67);
        Teacher albertEinstein = new Teacher("Albert Einstein", 73);
        Teacher billGates = new Teacher("Bill Gates", 62);

        school.addTeacher(williamShakespeare);
        school.addTeacher(adamMickiewicz);
        school.addTeacher(stefanBanach);
        school.addTeacher(boguslawWoloszanski);
        school.addTeacher(albertEinstein);
        school.addTeacher(billGates);
    }

    public static void addStudents(School school) throws NoSuchSchoolClassException {
        Student balladyna = new Student("Balladyna", 18);
        Student kordian = new Student("Kordian", 19);
        Student jurand = new Student("Jurand", 18);

        Student panTadeusz = new Student("Pan Tadeusz", 19);
        Student panWolodyjowski = new Student("Pan Wołodyjowski", 20);
        Student hamlet = new Student("Hamlet", 19);

        SchoolClass schoolClass1A = school.getSchoolClass("1A");
        schoolClass1A.addStudent(balladyna);
        schoolClass1A.addStudent(kordian);
        schoolClass1A.addStudent(jurand);

        SchoolClass schoolClass2C = school.getSchoolClass("2C");
        schoolClass2C.addStudent(panTadeusz);
        schoolClass2C.addStudent(panWolodyjowski);
        schoolClass2C.addStudent(hamlet);
    }

    public static void addTeacherToClasses(School school) throws NoSuchSchoolClassException, NoSuchTeacherException {
        SchoolClass schoolClass1A = school.getSchoolClass("1A");
        Teacher williamShakespeare = school.getTeacher("William Shakespeare");
        Teacher adamMickiewicz = school.getTeacher("Adam Mickiewicz");
        Teacher stefanBanach = school.getTeacher("Stefan Banach");

        schoolClass1A.addTeacher(williamShakespeare, Subject.ENGLISH);
        schoolClass1A.addTeacher(adamMickiewicz, Subject.POLISH);
        schoolClass1A.addTeacher(stefanBanach, Subject.MATH);

        SchoolClass schoolClass2C = school.getSchoolClass("2C");
        Teacher boguslawWoloszanski = school.getTeacher("Bogusław Wołoszański");
        Teacher albertEinstein = school.getTeacher("Albert Einstein");
        Teacher billGates = school.getTeacher("Bill Gates");

        schoolClass2C.addTeacher(boguslawWoloszanski, Subject.HISTORY);
        schoolClass2C.addTeacher(albertEinstein, Subject.PHYSICS);
        schoolClass2C.addTeacher(billGates, Subject.COMPUTER_SCIENCE);
    }

    public static void addMarks(School school) throws NoSuchTeacherException, NoSuchSchoolClassException, NoSuchStudentException {
        Teacher williamShakespeare = school.getTeacher("William Shakespeare");
        Teacher adamMickiewicz = school.getTeacher("Adam Mickiewicz");
        SchoolClass schoolClass1A = school.getSchoolClass("1A");

        williamShakespeare.addMark(Grade.A, Subject.ENGLISH, "Balladyna", schoolClass1A);
        adamMickiewicz.addMark(Grade.E, Subject.POLISH, "Balladyna", schoolClass1A);

        Teacher albertEinstein = school.getTeacher("Albert Einstein");
        SchoolClass schoolClass2C = school.getSchoolClass("2C");

        albertEinstein.addMark(Grade.C, Subject.PHYSICS, "Hamlet", schoolClass2C);
    }

    public static List<Mark> getMarks(School school) throws NoSuchSchoolClassException, NoSuchStudentException {
        return school.getSchoolClass("1A").getDiary().getMarks("Balladyna");
    }

    public static void main(String[] args) {
        School school = new School("School nr 15");

        try {
            addSchoolClasses(school);
            addTeachers(school);
            addStudents(school);
            addTeacherToClasses(school);
            addMarks(school);
            System.out.println(getMarks(school));
        } catch (TeacherAlreadyPresentException | SchoolClassAlreadyExistsException
                | NoSuchSchoolClassException | NoSuchTeacherException | NoSuchStudentException e) {
            e.printStackTrace();
        }
        System.out.println(school);
    }
}
