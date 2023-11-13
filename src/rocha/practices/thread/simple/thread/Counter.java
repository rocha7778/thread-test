package rocha.practices.thread.simple.thread;

import java.text.NumberFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread {

	private static int[] resource = new int[3];
	private static Lock lock = new ReentrantLock();

	public Counter(String name) {
		this.setName(name);
	}

	@Override
	public void run() {

		int j = 0;
		do {
			lock.lock();
			System.out.println("Thread [" + this.getName() + "] is increasing the value in index [" + j + "]");
			resource[j]++;
			sleep(500);
			lock.unlock();
			j++;

		} while (j < 3);

		System.out.println("Thread [" + this.getName() + "] sleep for a second");
	}

	public static void sleep(long miliseconds) {

		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printTotalCounter() {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		System.out.println("Total counter [0]" + format.format(resource[0]));
		System.out.println("Total counter [1]" + format.format(resource[1]));
		System.out.println("Total counter [2]" + format.format(resource[2]));
		
	}
}
