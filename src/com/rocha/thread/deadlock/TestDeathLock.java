package com.rocha.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeathLock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Lock stick1 = new ReentrantLock();
		Lock stick2 = new ReentrantLock();
		Lock stick3 = new ReentrantLock();

		DeathLockTest carlos = new DeathLockTest("Carlos", stick1, stick2);
		DeathLockTest paola = new DeathLockTest("Paola", stick2, stick3);
		DeathLockTest angie = new DeathLockTest("Angie", stick1, stick3);
		
		carlos.start();
		paola.start();
		angie.start();
		
		carlos.join();
		paola.join();
		angie.join();

	}

}
