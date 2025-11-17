package unit4;

import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bob"));
        students.add(new Student(2, "Alice"));
        students.add(new Student(3, "Eric"));

        students.sort((s1, s2) -> s1.id() - s2.id());
        students.forEach(t-> System.out.println(t.id() + " " + t.name()));


        students.sort((s1, s2) -> s1.name().compareTo(s2.name()));
        students.forEach(t-> System.out.println(t.id() + " " + t.name()));


    }
}
