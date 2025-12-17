package unit4.sortApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortTransaction {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SortTransaction <inputfile>");
            return;
        }

        List<Crate> list = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(args[0]))) {
            while (sc.hasNext()) {
                String receiver = sc.next();
                String date = sc.next();
                double mass = sc.nextDouble();
                list.add(new Crate(receiver, date, mass));
            }
        } catch (Exception e) {
            System.err.println("Error reading file.");
            return;
        }

        Crate[] crates = list.toArray(new Crate[0]);

        SelectionSort.sort(crates);

        for (Crate c : crates) {
            System.out.println(c);
        }
    }
}

