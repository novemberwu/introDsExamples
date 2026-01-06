package unit2.applications;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdStats;
import unit2.queue.Queue;
import unit2.queue.RandomQueue;
import unit2.queue.ResizeArrayQueue;

public class LoadBalance {
    public LoadBalance() {
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int s = Integer.parseInt(args[2]);
        RandomQueue<Queue<Integer>> servers = new RandomQueue();

        int j;
        for(j = 0; j < m; ++j) {
            servers.enqueue(new ResizeArrayQueue<>());
        }

        Queue queue;
        for(j = 0; j < n; ++j) {
            Queue<Integer> min = (Queue)servers.sample();

            for(int k = 1; k < s; ++k) {
                queue = (Queue)servers.sample();
                if (queue.size() < min.size()) {
                    min = queue;
                }
            }

            min.enqueue(j);
        }

        double[] lengths = new double[m];
        for(int i =0; i < servers.size(); i ++){
            lengths[i] = servers.get(i).size();
            System.out.println(lengths[i]);

        }
        StdDraw.setYscale(0, 2.0*n/m);
        StdStats.plotBars(lengths);
    }
}

