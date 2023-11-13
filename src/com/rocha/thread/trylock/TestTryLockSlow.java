package com.rocha.thread.trylock;

public class TestTryLockSlow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread barron = new Shopper2("Barron");
        Thread olivia = new Shopper2("Olivia");
        long start = System.currentTimeMillis();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (float)(finish - start)/1000 + " seconds");

	}

}
