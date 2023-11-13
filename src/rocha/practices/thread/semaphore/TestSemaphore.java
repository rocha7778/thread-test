package rocha.practices.thread.semaphore;

import java.text.NumberFormat;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class TestSemaphore extends Thread {

	private static Semaphore incrementer = new Semaphore(4);
	private static int[] resource = new int[4];
	private static int VECTOR_SIZE = resource.length;

	public TestSemaphore(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			incrementer.acquire();
			incrementResourceValue();
		} catch (Exception e) {
		} finally {
			incrementer.release();
		}
	}

	private void incrementResourceValue() throws InterruptedException {
		int j = 0;
		do {
			System.out.println("Thread [" + this.getName() + "] is increadins the value in idex [" + j + "]");
			resource[j]++;
			System.out.println("Thread [" + this.getName() + "] will sleep for a second");
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
			j++;

		} while (j < VECTOR_SIZE);

		System.out.println("Thread [" + this.getName() + "]  finisx the job");
	}

	public static void printTotalCounter() {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		System.out.println("Total counter [0]" + format.format(resource[0]));
		System.out.println("Total counter [1]" + format.format(resource[1]));
		System.out.println("Total counter [2]" + format.format(resource[2]));
		System.out.println("Total counter [3]" + format.format(resource[3]));
	}
}
