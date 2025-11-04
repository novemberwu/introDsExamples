package unit3;

public class UnionFindClient {

    public static void main(String[] args){
        //UnionFind uf = new MapUnionFindImpl(8);
        //Quickfind uf = new QuickFindImpl(8);
        //Quick union
        UnionFind uf = new QuickUnionImpl(8);

        // to build connected component
        //{0} {1 4 5} {2 3 6 7}
        uf.union(1,4);
        uf.union(4,5);


        uf.union(2,3);
        uf.union(2,6);
        uf.union(3,6);
        uf.union(3,7);

        System.out.println(uf.connected(0, 4)); // false
        System.out.println(uf.connected(5, 7));//false

        System.out.println(uf.connected(6, 7));//true




    }

}
