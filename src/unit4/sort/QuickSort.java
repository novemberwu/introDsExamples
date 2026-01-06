package unit4.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;


public class QuickSort {

    public static <T> void sort(T[] a, Comparator<T> comparator){
        StdRandom.shuffle(a);
        sort(a, 0, a.length -1, comparator);
    }

    private static <T> void sort(T[] a, int lo, int hi, Comparator<T> comparator){
        if(lo >= hi) return;
        int pivot = partition(a, lo, hi, comparator);

        sort(a, lo,pivot -1, comparator);
        sort(a, pivot + 1, hi, comparator);

    }

    /*
    Return the final position of pivot element (i.e. first element)
    The element to the left of pivot are less than it
    The element to the right of pivot are greater than it
     */
    private static <T> int partition(T[] a, int lo, int hi, Comparator<T> comparator){
       int i = lo, j = hi + 1;
       while(true){
           while(less(a[++i], a[lo], comparator))
               if(i == hi) break;
           while(less(a[lo], a[--j], comparator))
               if(j== lo) break;

           if( i >= j) break;
           swap(a, i, j);
       }

       swap(a, lo, j);
       return j;
    }

    private static <T> boolean less( T a, T b, Comparator<T> comparator){
        if(comparator.compare(a, b) < 0){
            return true;
        }else{
            return false;
        }
    }

    private static <T> void swap(T[] a, int indexI, int indexJ){
        T temp = a[indexI];
        a[indexI] = a[indexJ];
        a[indexJ] = temp;
    }

    public static void main(String[] args) {
        StudentScore[] s = new StudentScore[8];
        s[0] = new StudentScore("0", "G11", 84);
        s[1] = new StudentScore("1", "G11", 89);
        s[2] = new StudentScore("2", "G11", 80);
        s[3] = new StudentScore("3", "G11", 81);
        s[4] = new StudentScore("4", "G12", 84);
        s[5] = new StudentScore("5", "G12", 89);
        s[6] = new StudentScore("6", "G12", 80);
        s[7] = new StudentScore("7", "G12", 81);
        System.out.println("\nSort by score first");
        sort(s, StudentScore.sortByScore());
        Arrays.stream(s).forEach(System.out::println);

        System.out.println("\nSort by grade second");
        sort(s, StudentScore.sortByGrade());
        Arrays.stream(s).forEach(System.out::println);


    }
}
