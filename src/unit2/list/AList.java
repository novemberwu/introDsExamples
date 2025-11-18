package unit2.list;

// [11, 3 ,5, 77 , 0 , 0 ...]
//  0, 1, 2, 3 , 4,  5
//  size: 3
// addLast(11)
// addlast (3)
// addLast (5)
// addLast (77)

// conclusion: adding last, adding the new element at the position of size. increment size
// conclusion: get last, always return the element at the position of size -1
public class AList< Type > {

    private Type[] items ;// use this data member to store the items of the list
    private int size;

    private int capacity = 100;

    private static final double RFACTOR = 2.0;

    public AList(){
        size = 0;
        items = (Type[]) new Object[capacity];

    }

    public int size(){
        return size;
    }

    public Type get(int pos){
        if(pos >= size){
            throw new IndexOutOfBoundsException();
        }
        return items[pos];
    }

    public Type getFirst(){
        return items[0];
    }

    public void addFirst(Type x){
        if(size == items.length){
            //resize(size +1000);
            resize((int) (size * RFACTOR));
        }
        int i = size;
        while(i > 0){
            this.items[i] = this.items[i-1];
            i--;
        }
        this.items[i] = x;
        size +=1;
    }

    public void add(Type x , int position){
        if(position > size || position < 0)
            throw new IllegalArgumentException("Position should between 0 and size, inclusive");
        if(size == items.length){
            //resize(size +1000);
            resize((int) (size * RFACTOR));
        }
        int i = size;
        while (i > position){
            this.items[i] = this.items[i-1];
            i--;
        }
        this.items[i] = x;
        size +=1;
    }

    public Type removeFirst(){
        if(size < this.items.length/4){
            resize((int)(this.items.length / RFACTOR));
        }
        int i = 0 ;
        Type result = this.items[0];
        while ( i + 1 <  size ){
            this.items[i] = this.items[i + 1];
            i++;
        }
        size -= 1;
        return result;
    }

    public Type remove(int position){
        if(position >= size || position < 0)
            throw new IllegalArgumentException("Position should between 0 and size -1, inclusive");
        // to check if the array is too big to hold all elements

        if(size < this.items.length/4){
            resize((int)(this.items.length / RFACTOR));
        }
        // remove the item from the position
        int i = position ;
        Type result = this.items[position];

        while( i+1 < size){
            this.items[i]= this.items[i+1];
            i++;
        }

        this.items[i] = null;// nullout for garbage collector
        size -= 1;

        return result;
    }

    public void addLast(Type x){
        if(size == this.items.length){
            resize((int) (size * RFACTOR));
            //resize(size + 1000);
        }
        this.items[size] = x;
        size += 1;
    }



    public Type getLast(){
        return this.items[size -1];

    }

    public Type removeLast(){
        Type result = getLast();
        this.items[size -1] = null;
        size -=1;
        return result;
    }

    private void resize(int capacity){
        Type[] a = (Type[]) new Object[capacity];
        System.arraycopy(this.items,0, a,0, size);
        this.items = a;
    }


    public static void main(String[] args){
        AList<Integer> l = new AList<>();
        l.addFirst(10);
        l.addFirst(20);
        l.addFirst(30);
        for(int  i = 0; i < l.size; i ++){
            System.out.println(l.get(i));
        }

        AList<String> sl = new AList<>();
        sl.addFirst("Hello");
        sl.addFirst("World");
        for(int  i = 0; i < sl.size; i ++){
            System.out.println(sl.get(i));
        }
    }

}
