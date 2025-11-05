package unit2.stack;

public class Test {

    public static void main(String[] args){

        int n =50;
        Stack<Integer> stack = new LinkedListStack<>();
        while ( n > 0) {
            stack.push ( n % 2 ) ;
            n = n/2;
        }
        while (! stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
