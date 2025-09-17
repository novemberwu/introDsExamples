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
    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args){
        SLList l = new SLList(15);
        l.addFirst(10);
        l.first.next.next = l.first.next;
    }
}
