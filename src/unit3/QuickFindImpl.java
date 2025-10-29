package unit3;

public class QuickFindImpl implements UnionFind{

    private  int[] id;

    public QuickFindImpl(int N){
        id = new int[N];
        for(int i = 0 ; i < N; i ++){
            id[i] = i;
        }

    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0 ; i < id.length;i++){
            if(id[i] == qid){
                id[i] = pid;
            }
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
