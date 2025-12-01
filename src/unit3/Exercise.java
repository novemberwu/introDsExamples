package unit3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Exercise {

    private class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                } else {
                    parent[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                }
            }
        }

        public int getComponentSize(int i) {
            int root = find(i);
            return size[root];
        }
    }

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);

        Map<Integer, Integer> rowHead = new HashMap<>();
        Map<Integer, Integer> colHead = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int serverId = i * n + j;

                    if (!rowHead.containsKey(i)) {
                        rowHead.put(i, serverId);
                    } else {
                        uf.union(serverId, rowHead.get(i));
                    }

                    if (!colHead.containsKey(j)) {
                        colHead.put(j, serverId);
                    } else {
                        uf.union(serverId, colHead.get(j));
                    }
                }
            }
        }

        int communicatingServers = 0;
        Set<Integer> countedRoots = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int serverId = i * n + j;
                    int root = uf.find(serverId);

                    if (!countedRoots.contains(root)) {
                        int componentSize = uf.getComponentSize(root);
                        if (componentSize > 1) {
                            communicatingServers += componentSize;
                        }
                        countedRoots.add(root);
                    }
                }
            }
        }

        return communicatingServers;
    }

    public static void main(String[] args) {
        Exercise sol = new Exercise();

        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println("Example 1 Output: " + sol.countServers(grid1));

        int[][] grid2 = {{1, 0}, {1, 1}};
        System.out.println("Example 2 Output: " + sol.countServers(grid2));

        int[][] grid3 = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println("Example 3 Output: " + sol.countServers(grid3));
    }
}