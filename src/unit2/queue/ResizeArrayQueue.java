package unit2.queue;

import java.util.ArrayList;

public class ResizeArrayQueue<Type> implements Queue<Type>{
    private ArrayList<Type> items = new ArrayList<>();
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void enqueue(Type item) {
        items.add(item);

    }

    @Override
    public Type dequeue() {

        return items.remove(0);
    }

    @Override
    public Type sample() {

        return items.get(0);
    }

    @Override
    public Type get(int i) {
        return items.get(0);
    }
}
