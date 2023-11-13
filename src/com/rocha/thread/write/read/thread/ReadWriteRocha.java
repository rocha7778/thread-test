package com.rocha.thread.write.read.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteRocha extends Thread{

    private static final String[] WEEKDAYS = {"Sun", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static int today = 0;
    private ReentrantReadWriteLock marker = new ReentrantReadWriteLock();
    private Lock readerLock = marker.readLock();
    private Lock writeLock = marker.writeLock();


    public ReadWriteRocha(String name) {
		this.setName(name);
	}
    
    public void run(){

        int weeksize = WEEKDAYS.length - 1;

        while (today < weeksize){

            if(this.getName().contains("Writer")){
                // action belongs to writer thread
            	writeLock.lock();
                try {

                    today= (today +1) % 7; 
                    System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
                    
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

                {
                	writeLock.unlock();
                }
            }else{
                // action belongs to read thread
            	readerLock.lock();

                try {
                    
                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]);

                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }finally {
                	readerLock.unlock();
                }

            }

        }

    }
    
}
