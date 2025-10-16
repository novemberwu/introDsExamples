package unit2.list;

public class IntList {
    int first;
    IntList rest;

    public IntList(int first, IntList rest){
        this.first = first;
        this.rest = rest;
    }

    public int get(int i){
        if(i == 0){
            return first;
        }
        return rest.get(i-1);
    }

    public int size(){
        if(this.rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize(){
        IntList l = this;
        int size = 0;
        while(l!=null){
            size ++;
            l = l.rest;
        }
        return size;
    }

    public static IntList incrList(IntList L, int x){
        //Returns an IntList identical to L, but with all values incremented by x.
        //Values in L cannot change!
        //TODO: your implementation here
        return null;
    }
    public static IntList dincrList(IntList L, int x){
        //Returns an IntList identical to L, but with all values incremented by x.
        //Not allowed to use ‘new’ (to save memory).3
        //TODO: your implementation here
        return null;
    }



    public static void main(String[] args){
        IntList l = new IntList(5, null);
        l = new IntList(10, l);
        l = new IntList(15, l);
        int size = l.size();
        // Before any changes
        System.out.println("BEFORE ANY CHANGE");
        for(int i = 0; i < size; l.get(i)){
            System.out.println(l.get(i));
        }
        System.out.println("APPLY incrList");
        IntList q = incrList(l,3);

        System.out.println("APPLY incrList: original list");
        for(int i = 0; i < size; q.get(i)){
            System.out.println(q.get(i));
        }
        System.out.println("APPLY dincrList: original list");
        for(int i = 0; i < size; l.get(i)){
            System.out.println(l.get(i));
        }


    }
}
