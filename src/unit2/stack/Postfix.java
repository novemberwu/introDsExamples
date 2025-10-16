package unit2.stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        while(sc.hasNext()){
            String token = sc.next();
            if(token.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if(token.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if(token.equals("-"))
                stack.push(-stack.pop() + stack.pop());
            else if(token.equals("/"))
                stack.push(1/stack.pop() * stack.pop());
            else
                stack.push(Double.parseDouble(token));

        }

        System.out.println(stack.pop());

        sc.close();
    }
}
