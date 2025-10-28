package unit2.stack;

public class StackClientApp {
    public static void main(String[] args){
        Stack<Integer> s = new LinkedListStack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Size:"+s.size());
        System.out.println("Empty:"+s.isEmpty());

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());



    }
}
