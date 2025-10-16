package unit2.stack;

import unit2.list.SLList;


public class LinkedListStack<Type> implements Stack<Type>{
    private SLList<Type> items;

    public LinkedListStack(){
        items = new SLList<>();
    }
    @Override
    public void push(Type item) {
        items.addLast(item);
    }

    @Override
    public Type pop() {
        return this.items.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return this.items.size() == 0;
    }

    @Override
    public int size() {
        return this.items.size();
    }


}
