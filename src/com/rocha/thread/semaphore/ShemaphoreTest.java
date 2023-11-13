package com.rocha.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class ShemaphoreTest  extends Thread{
	
	private static Semaphore charger = new Semaphore(3);

	/**
	 * @param name
	 */
	public ShemaphoreTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			charger.acquire();
			System.out.println(this.getName() + "Is charging ...");
			
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println(this.getName() + "Charge complete");
			charger.release();
		}
	
	}
	
}
