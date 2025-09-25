package unit2;

public class SLList <Type> {
    private  static class Node <Type>{
        public Type item;
        public Node next;
        public Node(Type x, Node next){
            this.item = x;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    public SLList(Type x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }
    public SLList(){
        sentinel = new Node(null, null);
        size =0;
    }
    public  void addLast(Type x){
        Node n = this.sentinel;

        while(n.next != null){
            n = n.next;
        }
        n.next = new Node(x, null);
        size +=1;
    }
    /*private static int size(IntNode p){
        if(p.next == null) return 1;
        return size(p.next)+1;
    }

    public int size(){
        return size(first);
    }*/

    public  int size(){
        return  size;
    }


    public void addFirst(Type x){
        sentinel.next = new Node(x, sentinel.next);
        size +=1;
    }

    public Type getFirst(){
        return (Type)sentinel.next.item;
    }

    public static void main(String[] args){

        SLList<Integer> l = new SLList<>();
        l.addFirst(20);
        Integer i = l.getFirst();


        SLList<String> l2 = new SLList<>("Hi");
        l2.addFirst("World");
        System.out.println(l2.getFirst());
    }
}
