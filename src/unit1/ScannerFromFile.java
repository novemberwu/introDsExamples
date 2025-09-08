package unit1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFromFile {

    public static  void main(String[] args){
        scanFromFile();
    }

    public static void scanFromFile()  {
        Scanner sc = null;

        try {
            // initialize scanner to read from a file
            sc = new Scanner(new File("src/unit1/myNumbers"));
            // read from scanner until nothing left
            while (sc.hasNextLong()) {
                long aLong = sc.nextLong();
                System.out.println(aLong);
            }
        } catch (FileNotFoundException e) {
            // handle the file not found error
            throw new RuntimeException(e);
        }finally {
            // close the scanner to prevent resource leak
            if(sc != null){
                sc.close();
            }
        }
    }
}
