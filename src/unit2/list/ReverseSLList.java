package unit2.list;

public class ReverseSLList {

    private static class Node {
        public int item;
        public Node next;
        public Node(int x, Node next){
            this.item = x;
            this.next = next;
        }

    }
    /*
    implement the function to reverse the list, given node is the head of the list
     */
    public static void reverse(Node list){

    }

    public static void printList(Node list){
        Node p = list;
        while(p != null){
            System.out.println(p.item);
            p = p.next;
        }

    }

    public static void main(String[] args){
        Node head  = new Node(1,null);
        Node n1 = new Node(2, null);
        Node n2 = new Node(3, null);
        Node n3 = new Node(4, null);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        printList(head);


    }
}
