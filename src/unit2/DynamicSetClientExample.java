package unit2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DynamicSetClientExample {

    public static int[] readAllInt(){
        //int[] result = new int[];
        /* I need a dynamic set to stage the user input until completion */
        List<Integer> l = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            l.add(scanner.nextInt());
        }

        System.out.println("DEGUG:End of input ");
        // Now the size of user input is known now
        int size = l.size();
        System.out.println("DEGUG:input size: "+ size);

        // copy the values from the set to an array
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[i] = l.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        int[] result = readAllInt();
        for(int i : result){
            System.out.println(i);
        }
    }
}
