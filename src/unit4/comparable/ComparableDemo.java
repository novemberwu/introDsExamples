package unit4.comparable;

import unit4.comparable.StudentComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<StudentComparable> students = new ArrayList<>();
        students.add(new StudentComparable("Alice", 103));
        students.add(new StudentComparable("Bob", 110));

        students.add(new StudentComparable("Bob", 101));
        students.add(new StudentComparable("Charlie", 105));
        students.add(new StudentComparable("David", 102));

        System.out.println("Students before sorting:");
        for (StudentComparable student : students) {
            System.out.println(student);
        }

        // Sort the list of students using Collections.sort()
        // This method utilizes the compareTo() implementation in the Student class
        Collections.sort(students);

        System.out.println("\nStudents after sorting by ID:");
        for (StudentComparable student : students) {
            System.out.println(student);
        }
    }
}
