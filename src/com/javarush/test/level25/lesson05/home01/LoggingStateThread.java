package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {

    Thread targetThread;

    public LoggingStateThread(Thread targetThread) {
        this.targetThread = targetThread;
        setDaemon(true);
    }

    public void run(){
        State state = this.targetThread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.targetThread.getState())
            {
                state = this.targetThread.getState();
                System.out.println(state);
            }
        }
    }

}
