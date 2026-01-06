package unit4;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2};
        for(int i = 1; i < array.length; i++){
            for(int j = i; j >0; j--){
                if(array[j-1]> array[j]){
                    swap(array, j-1, j);
                }else{
                    break;// array[j-1] <= array[j]
                }
            }
        }


        Arrays.stream(array).forEach(System.out::println);
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
