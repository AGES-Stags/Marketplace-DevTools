package devtools.helper;

public class Timer {
    long startTime;
    long duration;
    public Timer(){  
    }
    
    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        long endTime = System.currentTimeMillis();
        duration = endTime - startTime;
    }

    public String toString(){
       return "timer: " + duration;
    }
}
