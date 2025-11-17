package unit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Define a custom class that implements Comparable
class StudentComparable implements Comparable<StudentComparable> {
    private String name;
    private int id;

    public StudentComparable(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + "]";
    }

    // Implement the compareTo method to define natural ordering by ID
    @Override
    public int compareTo(StudentComparable otherStudent) {
        // Compare students based on their ID
        // Returns a negative integer, zero, or a positive integer
        // as this object is less than, equal to, or greater than the specified object.
        return Integer.compare(this.id, otherStudent.id);
    }
}

