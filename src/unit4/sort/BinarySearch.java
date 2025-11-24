package unit4.sort;

public class BinarySearch {

    public static int binarySearch(Comparable[] a, int start , int end, Comparable target){
        int mid = (start + end)/2;

        if(a[mid].equals(target))
            return mid;

        if(start > end)
            return -1;

        if( less (a[mid], target)){
            return binarySearch(a, mid + 1, end, target);
        }else {
            return binarySearch(a, start, mid - 1, target);
        }

    }

    private static  boolean less( Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args){
        Integer[] a = {1, 3, 4, 6, 8, 2};
        System.out.println("index of 1:"+ binarySearch(a, 0, a.length -1, 1));
        System.out.println("index of 5:"+ binarySearch(a, 0, a.length -1, 5));

    }



}
