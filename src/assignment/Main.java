package assignment;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        File file = new File(fileName);
        Term[] terms;
        try(Scanner scanner = new Scanner(file)){
            int n = scanner.nextInt();
           terms = new Term[n];
            for(int i =0; i < n; i++){
                long weight = scanner.nextLong();
                String next = scanner.next();
                terms[i] = new Term(next.trim(), weight);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }


        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);

        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
