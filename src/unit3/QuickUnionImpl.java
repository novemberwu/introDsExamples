package unit3;

public class QuickUnionImpl implements UnionFind{

    private int[] parent;
    QuickUnionImpl(int N){
        this.parent = new int[N];
        for(int i =0; i < N; i++){
            this.parent[i] = i;
        }

    }


    @Override
    public void union(int p, int q) {
        int i = find (p);
        int j = find(q);

        if( i == j) return;

        parent[i] = j;

    }

    @Override
    public int find(int p) {
        while( p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
