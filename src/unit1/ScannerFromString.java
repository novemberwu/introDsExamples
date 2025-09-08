package unit1;

import java.util.Scanner;

public class ScannerFromString {
    public static void scanWithDelimiter(){
        // you can use https://regex101.com/ to study the regular expresion
        // however regular expression is out of the scope of the course

        String input = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
        s.close();
    }

    public static  void main(String[] args){
        scanWithDelimiter();
    }
}
