package com.rocha.thread.conditional.variable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HungryPersonUngradated extends Thread {

	private int personID;
	private static Lock slowCookerLid = new ReentrantLock();
	private static Condition takenSoup = slowCookerLid.newCondition();
	private static int servings = 11;

	public HungryPersonUngradated(int personID) {
		this.personID = personID;
	}

	public void run() {
		while (servings > 0) {
			slowCookerLid.lock();
			try {
				// System.out.println("Person id["+this.personID+"] result of servings " +
				// servings +" % 2 == " + (servings % 2));
				while ((personID != servings % 2) && servings > 0) { // check if it's the turn of the first thread
					takenSoup.await();
					System.out.format("Person %d checked... then put the lid back.\n", personID);
				}
				if (servings > 0) {
					System.out.println("Person id[" + this.personID + "] take a time to serve the soup");
					Thread.sleep(1000);
					servings--; // it's your turn - take some soup!
					System.out.format("Person %d took some soup! Servings left: %d\n", personID, servings);
					takenSoup.signalAll();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				slowCookerLid.unlock();
			}
		}
	}
}