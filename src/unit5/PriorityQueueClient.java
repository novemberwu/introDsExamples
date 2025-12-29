package unit5;

public class PriorityQueueClient {

    public static void testCase1(){
        MinPQ<Integer> pq = new MinPQ<>(10);
        pq.insert(50);
        pq.insert(20);
        pq.insert(40);
        pq.insert(10);
        pq.insert(30);

        System.out.println("\nAfter insertion the queue is");
        while (!pq.isEmpty()){
            System.out.println(pq.delMin());
        }


    }
    public static void main(String[] args) {
        testCase1();

    }
}
