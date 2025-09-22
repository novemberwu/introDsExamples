package unit2;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int x, IntNode next){
            this.item = x;
            this.next = next;
        }
    }
    private IntNode sentinel;
    private int size;

    public SLList(int x) {
        sentinel = new IntNode(-99, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }
    public SLList(){
        sentinel = new IntNode(-99, null);
        size =0;
    }
    public  void addLast(int x){
        IntNode n = this.sentinel;
//        if ( n == null){
//            this.first = new IntNode(x, null);
//            size +=1;
//            return;
//        }
        while(n.next != null){
            n = n.next;
        }
        n.next = new IntNode(x, null);
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


    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size +=1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public static void main(String[] args){

        SLList l = new SLList();
        l.addFirst(20);
        System.out.println(l.size);
        System.out.println(l.getFirst());
    }
}
