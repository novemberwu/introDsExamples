package unit4.sort;

import java.util.Arrays;

public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0 ; i < N; i++)
            for(int j = i; j > 0; j--)
                if(less(a[j] , a[j-1]))
                    exch(a, j, j-1);
                else break;
    }

    public static void sortHalfExchange(Comparable[] a){
        int N = a.length;
        Comparable temp ;
        for (int i = 0 ; i < N; i++){
            temp = a[i];
            int j = i;
            for(; j > 0; j--){
                if(less(temp , a[j-1])){
                    a[j] = a[j-1];
                }else{
                    break;
                }
            }
            a[j] = temp;
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch( Comparable[] a, int v, int w){
        Comparable temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }

    public static void main(String[] args){
        Integer[] a = {3, 4, 6, 2, 1, 0};
        sortHalfExchange(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
