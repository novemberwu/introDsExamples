package unit2.queue;

public interface Queue <Type>{
    boolean isEmpty();
    int size();
    void enqueue(Type item);
    Type dequeue();
    Type sample();
    Type get(int i );
}
