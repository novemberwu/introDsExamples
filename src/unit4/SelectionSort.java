package unit4;

import java.util.Arrays;

public class SelectionSort {

    //[3, 1, 2] --> [1, 2, 3]
    public static void main(String[] args) {
        int[] array = {3, 1, 2};
        sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minValue = array[i];
            int minIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < minValue){
                    minValue = array[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

        }

    }
}
