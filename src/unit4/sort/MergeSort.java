package unit4.sort;

import java.util.Arrays;

import static unit4.sort.SortUtils.less;

public class MergeSort {

    public static void main(String[] args){
        Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        Integer[] aux = new Integer[a.length];
        //merge(a,aux, 0,3, 7 );

        mergeSort(a, 0, a.length-1);

        Arrays.stream(a).forEach(System.out::println);
    }

    public static void mergeSort(Comparable[] a, int low , int high){
        if(high <= low) return;// base
        int mid = (low + high)/2;
        mergeSort(a , low, mid);
        mergeSort(a, mid+1, high);

        Comparable[] aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        merge(a,aux, low, mid, high);
    }

    // use aux  as auxiliary array to merge sorted subarray a[low..mid] and a[mid+1..hi]
    private static void merge(Comparable[] a, Comparable[] aux, int low , int mid , int hi){

        for(int  i = low ; i <= hi; i ++){
            aux[i] = a[i];
        }
        int i = low;
        int j = mid + 1;

        for(int k = low; k <= hi; k++){
            if(j > hi)
                a[k] = aux[i++];
            else if (i > mid)
                a[k] = aux[j++];
            else if (less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }

    }


}
