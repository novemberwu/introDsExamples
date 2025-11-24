package unit4.sort;

public class BinarySearchIterative {


    public static int binarySearch(Comparable[] a, int start, int end, int target){
        if(start > end) return -1;

        while(start <= end){
            int mid = (start+end)/2;

            if(a[mid].equals(target))
                return mid;

            if(less(a[mid], target)){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }

        return -1;
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
