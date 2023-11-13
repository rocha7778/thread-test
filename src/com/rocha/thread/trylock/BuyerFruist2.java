package com.rocha.thread.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyerFruist2 extends Thread {

	public static int[] fruists = new int[5];
	private static int index = 0;
	private boolean isFruitNeededToAdd = true;
	private static Lock pencil = new ReentrantLock();

	public BuyerFruist2(String threadName) {
		super.setName(threadName);
	}

	@Override
	public void run() {

		while (index <= 4) {

			if (fruists[index] == 0) {

				System.out.println(
						"Thread reading " + this.getName() + " Conten of array: " + fruists[index] + " index " + index);
			}

			
			if (index <=4) {
				pencil.lock();
				fruists[index]=1;
				index++;
				pencil.unlock();
			}
			
		}
	}

}
