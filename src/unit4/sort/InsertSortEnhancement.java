package unit4.sort;

import java.util.Arrays;

public class InsertSortEnhancement {

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args){
        Integer[] a = {2, 2, 3, 3, 4};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void sort(Comparable[] a) {

        int i = 1;
        while (i < a.length) {

            Comparable target = a[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int middle = (right + left) / 2;
                if (less(target, a[middle])) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // if we are here. the left position is the postion to insert target
            int j = i;
            for (; j > left; j--) {
                a[j] = a[j - 1];
            }
            // j== left
            a[j] = target;
            i++;
        }
    }
}
