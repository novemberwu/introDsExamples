package unit2;

public class SpeedTestSLList {
    public static void speedTest(int count){
        SLList<Integer> l  = new SLList<>();

        long startTime = System.currentTimeMillis();
        int i =0;
        while ( i < count){
            l.addFirst(i);
            i = i+1;
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("\n%10d        %5d\n", count,(endTime - startTime));

    }
    public static void main(String[] args){
        System.out.printf("%10s        Time(ms)", "N");
        for(int count = 10000; count <=10000000; count *=10){
            speedTest(count);
        }
    }
}
