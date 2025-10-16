package unit2.stack;

public interface Stack<Type> {

    void push(Type item);
    Type pop();
    boolean isEmpty();
    int size();

}
