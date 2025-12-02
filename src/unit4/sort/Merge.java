package unit4.sort;

import java.util.Arrays;

import static unit4.sort.SortUtils.less;

public class Merge {

    public static void main(String[] args){
        Integer[] num1 = {1, 3, 5, 7, 9, 0, 0};
        Integer[] num2 = {2, 4 };
        merge(num1, num2, 5, 2);

        Arrays.stream(num1).forEach(System.out::println);
    }
    public static void merge(Comparable[] a, Comparable[] b, int sizea, int sizeb){
        int k  = sizea + sizeb - 1;
        int i = sizea -1 ;
        int j = sizeb -1;
        for(; k >= 0; k--){
            if(i < 0){
                a[k] = b[j--];
            }
            else if(j< 0){
                a[k] = a[i--];
            }
            else if(less(a[i], b[j])){
                a[k] = b[j--];
            }else{
                a[k] = a[i--];
            }
        }



    }
}
