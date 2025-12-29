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

    public static void testCase2(){
        MinPQ<String> pq = new MinPQ<>(10);
        pq.insert("Z");
        pq.insert("A");
        pq.insert("M");
        pq.insert("B");

        System.out.println("\nAfter insertion the queue is");
        while (!pq.isEmpty()){
            System.out.println(pq.delMin());
        }
    }

    public static void testCase3(){
        MinPQ<Integer> pq = new MinPQ<>(10);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);

        System.out.println("\nAfter insertion the queue is");
        while (!pq.isEmpty()){
            System.out.println(pq.delMin());
        }
    }

    public static void testResize(){
        MinPQ<Integer> pq = new MinPQ<>(10);
        for(int i = 20; i >=1; i--)
            pq.insert(i);

        System.out.println("\nAfter insertion the queue is");
        while (!pq.isEmpty()){
            System.out.println(pq.delMin());
        }


    }
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testResize();

    }
}
