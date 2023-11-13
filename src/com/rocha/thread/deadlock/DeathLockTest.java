package com.rocha.thread.deadlock;

import java.util.concurrent.locks.Lock;

public class DeathLockTest extends Thread {

	private static int sushiCount = 500;
	private Lock palillo1, palillo2;

	/**
	 * @param palillo1
	 * @param palillo2
	 */
	public DeathLockTest(String name, Lock palillo1, Lock palillo2) {
		super();
		this.palillo1 = palillo1;
		this.palillo2 = palillo2;
		this.setName(name);
	}

	@Override
	public void run() {
		int sushiTaken = 0;

		while (sushiCount > 0) { // eat all sushi until it is all gone

			palillo1.lock();
			palillo2.lock();
			if (sushiCount > 0) {
				sushiTaken++;
				sushiCount--;
			}
			//System.out.println(this.getName() + " tooke a piece! Sishi remaining: " + sushiCount);
			palillo2.unlock();
			palillo1.unlock();

		}

		System.out.println(this.getName() + " tooke a total of sushi: " + sushiTaken);

	}

}
