package unit4.sort;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args){
        int[]a = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        move(a);


    }

    private static void printArray(int[] a){
        System.out.println();
        Arrays.stream(a).forEach(t->System.out.printf(" "+ t));

        System.out.println();

    }

    public static void move(int[] a){
        int i = 0 ;
        int j = 0;
        while(true){
            while(j < a.length && a[j] !=0){
                j++;
            }
            i = j+1;
            while( i < a.length && a[i]==0){
                i++;
            }
            if(i == a.length || j == a.length){
                break;
            }
            if( i > j){
                swap (a, i, j);
            }

            printArray(a);

        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
