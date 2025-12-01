package unit4.sort;

public class Stopwatch {

    private final  long startTime;
    public Stopwatch(){
        // implementation here
        startTime = System.currentTimeMillis();

    }


    public double elapsedTime(){
        // implementation here
        long current = System.currentTimeMillis();
        return (current - startTime) / 1000.0;
    }


}
