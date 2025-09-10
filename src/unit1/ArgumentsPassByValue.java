package unit1;

public class ArgumentsPassByValue {


    public static void swapPrimitives(int a , int b){
        // Print the arguments before operations
        System.out.println("Within method, before swap");
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        // swap a and b
        int t = a;
        a = b;
        b = t;

        System.out.println("Within method, after swap");
        System.out.println("a:"+a);
        System.out.println("b:"+b);

    }


    public static void main(String[] args){
        int a = 1;
        int b = 2;

        System.out.println("MAIN, before swap");
        System.out.println("a:"+a);
        System.out.println("b:"+b);

        swapPrimitives(a, b);

        System.out.println("MAIN, after swap");
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }


}
