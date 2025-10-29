package unit3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUnionFindImpl implements UnionFind{

    private Map<Integer, List<Integer>> sets;
    public MapUnionFindImpl(int N){
        sets = new HashMap();
        for(int i = 0 ; i < N; i ++){
            List a = new ArrayList();
            a.add(i);
            sets.put(i, a);
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if(pid != qid){
            sets.get(pid).addAll(sets.get(qid));
            sets.remove(qid);
        }
    }

    @Override
    public int find(int p) {
        for(int key : sets.keySet()){
            if(sets.get(key).contains(p))
                return key;
        }
        return -1;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public static void main(String[] args){
        MapUnionFindImpl m  = new MapUnionFindImpl(4);
        m.union(1,3);
        System.out.println(m.connected(1,3));//true
        m.union(2,3);
        System.out.println(m.connected(1,2));//true

        System.out.println(m.connected(0,3));//false
    }
}
