package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private static AtomicInteger currentPriority = new AtomicInteger(0);

    public MyThread(){
        init();
    }

    public MyThread(Runnable runnable) {
        super(runnable);
        init();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
        init();
    }

    public MyThread(String s) {
        super(s);
        init();
    }

    public MyThread(ThreadGroup threadGroup, String s) {
        super(threadGroup, s);
        init();
    }

    public MyThread(Runnable runnable, String s) {
        super(runnable, s);
        init();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s) {
        super(threadGroup, runnable, s);
        init();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l) {
        super(threadGroup, runnable, s, l);
        init();
    }

    private void init()
    {
        currentPriority.incrementAndGet();
        currentPriority.compareAndSet(11, 1);

        int newPriority = currentPriority.get();

        if (getThreadGroup() != null)
        {
            if (newPriority > getThreadGroup().getMaxPriority())
            {
                newPriority = getThreadGroup().getMaxPriority();
            }
        }

        setPriority(newPriority);
    }
}
