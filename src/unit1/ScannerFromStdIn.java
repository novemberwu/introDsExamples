package unit1;

import java.util.Scanner;

public class ScannerFromStdIn {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter int value:");
        int i = sc.nextInt();

        System.out.println("Please enter string:");
        String s = sc.next();
        System.out.println("Getting from input: " + i + " and "+ s);
    }
}
