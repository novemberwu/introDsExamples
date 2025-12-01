package unit4.sort;

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
        Stopwatch s = new Stopwatch();

        sort(a);

        System.out.printf("Insertion Sort on Size %d: %.3f", N, s.elapsedTime());

        validate(a);

    }
}
