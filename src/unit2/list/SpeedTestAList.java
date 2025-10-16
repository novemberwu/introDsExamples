package unit2.list;

import unit2.list.AList;

public class SpeedTestAList {

    public static void speedTest(int count){
        AList l  = new AList();

        long startTime = System.currentTimeMillis();
        int i =0;
        while ( i < count){
            l.addLast(i);
            i = i+1;
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("\n%10d        %5d\n", count,(endTime - startTime));

    }
    public static void main(String[] args){
        System.out.printf("%10s        Time(ms)", "N");
        for(int count = 10000; count <=100000; count *=10){
            speedTest(count);
        }

    }
}
