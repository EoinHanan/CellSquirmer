package Multithreading;

public class Clock extends Thread{
    private long startTime;
    private long currentTime;
    private boolean isStarted;

    public void startThread(){
        this.startTime = System.currentTimeMillis();
        this.isStarted = true;
    }

    public void run(){
        while (isStarted){

        }
    }

    public int[] getTime()
    {
        currentTime = System.currentTimeMillis();
        long time = currentTime - startTime;
        int [] out = new int[2];
        //Minutes
        out[0] = (int)(time / 60000);
        //Seconds
        out[1] = (int)(time / 1000);
        return out;
    }
    
    public void stopThread(){
        this.isStarted = false;
    }
}
