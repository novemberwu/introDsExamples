package unit4.sort;

import java.util.Arrays;

import static unit4.sort.SortUtils.less;

public class MergeSort {

    public static void main(String[] args){
        Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        merge(a, 0,3, 7 );

        Arrays.stream(a).forEach(System.out::println);
    }

    // use aux array as auxiliary array to merge sorted subarray a[low..mid] and a[mid+1..hi]
    private static void merge(Comparable[] a, int low , int mid , int hi){
        Comparable[] aux = new Comparable[a.length];

        for(int  i = low ; i <= hi; i ++){
            aux[i] = a[i];
        }

        int i = low; // this is used to iterate a[low.. mid]
        int j = mid + 1; // this is used to iterate a[mid +1 ... hi]
        int k = low; // this is used for tracing the position of writes in a

        for(; k <= hi; k++){
            // both half of the array are not exhausted
            if( i <= mid && j <= hi){
                if(less(aux[i], aux[j])){
                    a[k] = aux[i];
                    i++;
                }else{
                    a[k] = aux[j];
                    j++;
                }
            } else if ( i > mid){
                a[k]= aux[j];
                j++;
            }else{
                a[k] = aux[i];
                i++;

            }


        }

    }


}
