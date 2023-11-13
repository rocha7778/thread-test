package com.rocha.thread.write.read.thread;

public class ReadWriteLockDemo2 {
    public static void main(String[] args) {
        // create ten reader threads
        for (int i=0; i<10; i++) {
            new ReadWriteRocha("Reader-"+i).start();
        }

        // ...but only two writer threads
        for (int i=0; i<2; i++) {
            new ReadWriteRocha("Writer-"+i).start();
        }
    }
}

