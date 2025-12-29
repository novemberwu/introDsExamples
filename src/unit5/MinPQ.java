package unit5;

public class MinPQ <Key extends  Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    private int R_FACTOR = 2;


    public MinPQ(int capacity){
        this.N = 0;
        this.pq = (Key[]) (new Comparable[capacity+1]);
    }

    private boolean greater(int i, int j){
        return pq[i].compareTo(pq[j]) > 0;
    }
    private void exch( int i, int j){
        Key temp = pq[i];
        pq[i]= pq[j];
        pq[j]= temp;
    }

    private void swim(int k){
        while(k > 1 && greater(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k){
        while( 2 * k <= N){
            int j = 2 * k;
            if( j < N && greater(j, j+1))j++;
            if(!greater(k, j))break;
            exch(k,j);
            k = j;
        }
    }

    private void resize(){
        int newCapacity = this.pq.length * R_FACTOR;
        Comparable[] newArray = new Comparable[newCapacity];
        for(int i = 1; i <= this.N; i++){
            newArray[i] = this.pq[i];
        }

        this.pq = (Key[])newArray;
    }
    public void insert(Key v){
        if(this.N == this.pq.length -1 ){
            resize();
        }
        this.N++;
        this.pq[N] = v;
        swim(N);
    }

    public Key delMin(){
        Key max = this.pq[1];
        exch(1, this.N);
        N--;
        sink(1);
        this.pq[N+1]= null;
        return max;
    }

    public boolean isEmpty(){
        return this.N ==0;
    }
}
