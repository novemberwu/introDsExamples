package unit2.queue;

import java.util.ArrayList;

public class RandomQueue<Type> implements Queue<Type>{

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

    private void randomSwap(){

        int index = (int)(Math.random() * items.size());
        Type temp = items.get(items.size() -1);
        items.set(items.size()-1, items.get(index));
        items.set(index, temp);

    }

    @Override
    public Type dequeue() {
        if(items.isEmpty()) throw new RuntimeException("Empty queue");

        randomSwap();
        return items.remove(items.size() -1);
    }

    @Override
    public Type sample() {
        if(items.isEmpty()) throw new RuntimeException("Empty queue");

        randomSwap();

        return items.get(items.size() -1);
    }

    @Override
    public Type get(int i) {
        return items.get(i);
    }
}
