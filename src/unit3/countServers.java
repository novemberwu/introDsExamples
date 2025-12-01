package unit3;

public class countServers {
    private int[] id;
    private int[] sz;

    public int countServers(int[][] grid) {
        QuickUnionImpl(grid.length*grid[0].length);
        for (int i=0; i< grid.length; i++){
            int server = -1;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] ==1){
                    if (server == -1){
                        server = i*grid[0].length + j;
                    } else {
                        union(server, i*grid[0].length + j);
                    }
                }
            }
        }
        for (int i=0; i< grid[0].length; i++){
            int server = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] ==1){
                    if (server == -1){
                        server = j*grid[0].length + i;
                    } else {
                        union(server, j*grid[0].length + i);
                    }
                }
            }
        }
        int[] count = new int[grid.length*grid[0].length];
        for (int i=0; i<sz.length; i++){
            int root = find(i);
            count[root]++;

        }
        int connectedComputers = 0;
        for (int i: count){
            if (i>1){
                connectedComputers+=i;
            }
        }
        return connectedComputers;
    }

    public void QuickUnionImpl(int size){
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        }
//        id[rootp] = rootq;
    }


    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }


    public static void main(String[] args) {
        countServers cs = new countServers();
        System.out.println(cs.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }
}
