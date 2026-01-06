package unit4;

public class BinarySearch {
    public static int search(int[] array, int target){
        int left = 0;
        int right = array.length -1;
        int mid =  -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(array[mid] == target) return mid;
            else if( array[mid] < target){
                left  = mid + 1;
            }else{
                // target < array[mid]
                right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 8,12, 16, 23, 38, 56, 72, 91};
        int target = 56;

        System.out.println(search(a, target ));// should print 7
    }
}
