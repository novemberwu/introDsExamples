package unit3;

public class WeightedQuickUnionImpl implements  UnionFind{
    private int[] parent;
    private int[] sz;

    WeightedQuickUnionImpl(int N){
        this.parent = new int[N];
        for(int i =0; i < N; i++){
            this.parent[i] = i;
            this.sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if(i == j) return;

        if(sz[i] < sz [j]){
            parent[i] = j;
            sz [j] += sz[i];
        }else{
            parent[j] = i;
            sz[i] += sz[j];

        }

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
