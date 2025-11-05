package unit2.stack;

import unit2.queue.Queue;
import unit2.queue.ResizeArrayQueue;

public class Test2 {

    public static void main(String[] args){
        Stack<String> stack = new LinkedListStack<>();
        Queue<String> queue = new ResizeArrayQueue<>();
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
    }
}
