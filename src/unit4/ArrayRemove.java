package unit4;

import java.util.Arrays;

public class ArrayRemove {

    public static void insert(int[] array, int size, int target){
        int j = size -1;
        while(j>=0 && array[j] > target ){
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = target;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, -1};
        insert(array,5, 0);
        Arrays.stream(array).forEach(System.out::println);


    }
}
