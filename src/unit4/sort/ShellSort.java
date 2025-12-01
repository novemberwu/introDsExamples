package unit4.sort;

public class ShellSort {
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch( Comparable[] a, int v, int w){
        Comparable temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }
    // This is h-sort function
    // where sort the array with insertion sort of step h
    public static void sort(int h, Comparable[] a){
        int N = a.length;
        for (int i = h ; i < N; i++)
            for(int j = i; j >= h; j-=h)
                if(less(a[j] , a[j-h]))
                    exch(a, j, j-h);
                else break;
    }


    public static void shellSort(Comparable[] array){
        int i = 1;
        while(i < array.length/3) i = i * 3 +1;

        while(i >=1){
            sort(i, array);
            i /= 3;
        }

    }

    public static boolean validate(Integer[] a){
        for(int i = 0; i < a.length ; i++){
            if(a[i] != i){System.out.println("sort error at index"+i);
               return  false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];
        for(int i = a.length-1; i >=0 ; i--){
            a[a.length -1 -i] = i;
        }

        Stopwatch s  = new Stopwatch();
        shellSort(a);


        System.out.printf("Shell Sort on Size %d: %.3f", N, s.elapsedTime());
        validate(a);

    }
}
