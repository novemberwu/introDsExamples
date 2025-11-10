package unit2.stack;

import unit2.queue.Queue;
import unit2.queue.ResizeArrayQueue;

public class StackQueueApplication {

    public static void main(String[] args){
        Stack<String> stack = new LinkedListStack<>();
        Queue<String> queue = new ResizeArrayQueue<>();
        queue.enqueue("Viva");
        queue.enqueue("la");
        queue.enqueue("vida");
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
