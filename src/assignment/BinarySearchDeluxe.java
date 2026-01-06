package assignment;

import java.util.Comparator;

public class BinarySearchDeluxe {



    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        if(a == null || key == null) throw new IllegalArgumentException();

        int low = 0  ;
        int high =  a.length -1;

        int preIndex = -1;
        while(low <= high){
            int mid = low + (high  -low)/2;
            if(comparator.compare(a[mid], key) >= 0){
                preIndex = mid;
                high = mid -1;
            }else{
                low = mid +1;

            }

        }
        return preIndex;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
        if(a == null || key == null) throw new IllegalArgumentException();

        int low = 0  ;
        int high =  a.length -1;

        int preIndex = -1;
        while(low <= high){
            int mid = low + (high  -low)/2;
            if(comparator.compare(a[mid], key) <= 0){
                preIndex = mid;
                low = mid +1;
            }else{
                high = mid-1;
            }

        }
        return preIndex;

    }

    // unit testing (required)
    public static void main(String[] args){
        Integer[] testArray = {1, 1, 1,1,1,2,2,2,2,2,3,3,3,3};
        System.out.println(firstIndexOf(testArray, 1, Integer::compare));
        System.out.println(lastIndexOf(testArray, 1, Integer::compare));
    }
}
