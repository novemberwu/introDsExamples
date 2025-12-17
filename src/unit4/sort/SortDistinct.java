package unit4.sort;

import java.util.Arrays;

public class SortDistinct {
    public static void main(String[] args) {
        int[] array = generateArray();
        printArray(array);

        int pivot = array[0];
        int gt = array.length -1;
        int i = 1;
        int lt = 0;
        while(i <= gt){
            if(array[i] == pivot)
                i++;
            else if(array[i] > pivot){
                swap(array, i, gt);
                gt --;
            }else{ // array [i] < pivot
                swap(array, i , lt);
                lt ++;
                i++;
            }
        }

        printArray(array);

    }

    private static void printArray(int[] array){
        System.out.println();
        Arrays.stream(array).forEach(t-> System.out.print("  "+ t+ " "));

    }

    private static void swap(int[] array, int i , int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int[] generateArray(){
//        int N = 10;
//        int[] result = new int[N];
//        for(int i = 0; i < N; i++){
//            if(Math.random() > 0.5){
//                result[i] = 1;
//            }else{
//                result[i] = 2;
//            }
//        }
//        return  result;
        int[] result = {2 ,  2  , 2 ,  1 ,  2 ,  1  , 2 ,  1  , 2  , 1 };
        return result;
    }
}
