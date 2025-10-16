package unit1;

import java.io.File;
import java.util.Scanner;

public class ScannerCat {

    public static void main(String[] args){
        String path = "src/unit1/ScannerCat.java";
        readFromFile(path);
    }

    public static void readFromFile(String filePath){
        Scanner sc = null;
        try{
            File f = new File(filePath);
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                String st = sc.nextLine();
                System.out.println(st);
            }

        }catch (Exception e){
            throw  new RuntimeException(e);

        }finally {
            if(sc != null){
                sc.close();
            }
        }
    }
}
