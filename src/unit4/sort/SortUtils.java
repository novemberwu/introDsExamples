package unit4.sort;

public class SortUtils {

    public static boolean less (Comparable a , Comparable b){
        return a.compareTo(b) < 0;
    }
    public static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
