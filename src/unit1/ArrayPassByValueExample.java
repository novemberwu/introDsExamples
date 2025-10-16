package unit1;

import java.util.Arrays;

public class ArrayPassByValueExample {

    // primitive types
    // int , short , long , char, boolean , float , double
    // except for above, all the other types are reference types
    // int[] ---> reference type
    public static int negative1(int x){
        x = -x;
        return x;
    }

    public static void negative2(int[] a){
        for(int i =0; i < a.length; i++){
            negative1(a[i]);
        }
    }

    public static void negative3(int[] a){
        for(int i =0; i < a.length; i ++){
            a[i] = -a[i];
        }
    }

    public static void negative4(int[] a){
        for(int i =0; i < a.length; i ++){
            a[i] = negative1(a[i]);
        }
    }

    public static void print(int[] a){
        Arrays.stream(a).forEach(num -> System.out.print(num));
        System.out.println();
    }

    public static  void main(String[] args){
        int y = 256;
        int z = negative1(y);
        System.out.println(y);
        System.out.println(z);



        int[] a = new int[]{1, 2, 6};
        negative2(a);
        System.out.println("After negative2:");
        print(a);
        // negative 3 is passing a[], a[] is a reference (address)
        a = new int[]{1, 2, 6};
        negative3(a);
        System.out.println("After negative3:");
        print(a);

        //negative 4 is a passing a[], a[] is a reference(address)
        a = new int[]{1, 2, 6};
        negative4(a);
        System.out.println("After negative4:");
        print(a);

    }
}
