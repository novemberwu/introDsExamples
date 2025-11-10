package unit2.list;

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

    public void add(Type x, int position){
        //step 1: iterate until the position
        Node p = this.sentinel;
        int step = 0;
        while(step < position){
            p = p.next;
            step ++;
        }
        Node next = p.next;
        p.next = new Node(x, next);

    }

    public Type remove(int position){
        //step 1 : iterate until position -1 node
        Node p = this.sentinel;
        int step = 0;
        while(step < position){
            p = p.next;
            step++;
        }
        // step 2: remove the item at position
        Node target = p.next;
        p.next = target.next;
        target.next = null;
        return (Type) target.item;
    }

    public Type removeLast(){

        if(size == 0) throw new IndexOutOfBoundsException();

        size --;

        Node n = sentinel;
        Node pre = sentinel;
        while(n.next != null){
            pre = n;
            n = n.next;
        }

        pre.next = n.next;
        return (Type)n.item;
    }


    public Type getLast(){
        Node n = this.sentinel;
        while(n.next != null){
            n = n.next;
        }

        return (Type)n.item;
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

    public Type removeFirst(){
        if(size == 0) throw new IndexOutOfBoundsException();

        Node n = this.sentinel.next;
        this.sentinel.next = n.next;

        size --;

        return (Type)n.item;
    }

    public static void main(String[] args){

        SLList<Integer> l = new SLList<>();
        l.addFirst(20);
        Integer i = l.getFirst();


        SLList<String> l2 = new SLList<>("Hi");
        l2.addFirst("World");
        System.out.println(l2.getFirst());

        String node = l2.removeLast();
        System.out.println(node);
    }
}
