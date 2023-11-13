package com.rocha.thread.trylock;

public class TestTryLock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread barron = new Shopper("Barron");
        Thread olivia = new Shopper("Olivia");
        long start = System.currentTimeMillis();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (float)(finish - start)/1000 + " seconds");

	}

}
