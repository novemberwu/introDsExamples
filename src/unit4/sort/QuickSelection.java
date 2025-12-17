package unit4.sort;

import static unit4.sort.SortUtils.less;
import static unit4.sort.SortUtils.swap;

public class QuickSelection {
    public static Comparable selection(Comparable[] a, int k){
        return selection(a, k, 0, a.length -1);

    }

    private static Comparable selection(Comparable[] a, int k, int low, int high){
        int  p = partition(a, low, high);
        if(k < p){
            return selection(a, k, low, p -1);
        }else if (k > p){
            return selection(a, k, p +1 , high);
        }else {
            return a[k];
        }
    }

    private static int partition(Comparable[] a, int lo, int hi){
        Comparable pivot  = a[lo];
        int i = lo +1 ;
        int j = hi;
        // implementation of partition
        while(true){
            while(less(a[i], pivot)){

                if( i == hi){
                    break;
                }
                i++;
            }
            while(less(pivot , a[j])){

                if( j== lo){
                    break;

                }
                j--;
            }
            //
            if(i >= j){
                break;
            }
            swap(a, i, j);

        }
        swap(a, lo, j);


        return j; // this should return meaningful pivot position
    }

    public static void main(String[] args) {
        Integer[] a = {99, 34, 6, 2, 33, -11, 25};

        System.out.println(selection(a, 0));
    }


}
