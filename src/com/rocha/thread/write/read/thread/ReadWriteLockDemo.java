package com.rocha.thread.write.read.thread;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        // create ten reader threads
        for (int i=0; i<10; i++)
            new CalendarUser("Reader-"+i).start();

        // ...but only two writer threads
        for (int i=0; i<2; i++)
            new CalendarUser("Writer-"+i).start();
    }
}

