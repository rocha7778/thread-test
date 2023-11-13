package com.rocha.thread.race.condition;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shopper extends Thread {

	public static int bagsOfChips = 1;
	private static Lock pencil = new ReentrantLock();
	private static CyclicBarrier  orderOperation = new CyclicBarrier(10);

	public Shopper(String name) {
		super(name);
	}

	public void run() {

		if (this.getName().contains("Olivia")) {
			pencil.lock();
			try {
				bagsOfChips += 3;
				System.out.println(this.getName() + " Added three bags of chips");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pencil.unlock();
			}
			
			try {
				orderOperation.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} else {
			
			try {
				orderOperation.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			pencil.lock();
			try {
				bagsOfChips *= 2;
				System.out.println(this.getName() + "Doubled the bags o chips");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pencil.unlock();
			}
		}

	}

}
