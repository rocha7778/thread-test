package com.rocha.thread.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyerFruist extends Thread {

	private static final int TOTAL_BUKETS_OF_FRUITS = 5;
	static int[] fruists = new int[TOTAL_BUKETS_OF_FRUITS];
	static int numberFruitsToBuy = 0;
	static int fruitToBuy = 0;
	
	private final int APPLE = 0;
	private final int PEAR = 1;
	private final int BLACKBERRY = 2;
	private final int MANGO = 3;
	private final int GUAVA = 4;
	private static Lock pencil = new ReentrantLock();

	public BuyerFruist(String threadName) {
		super.setName(threadName);
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			numberFruitsToBuy++;
			if(areThereFruitsForBuying(i)) {
				buyFruit(i);
			}
		}

	}

	private boolean areThereFruitsForBuying(int i) {

		//System.out.println(this.getName() + " asking if are there fruits for buying");
		boolean result = false;
		if(i<=4) {
			result = (fruists[i] == 0);
		}
		if (result) {
			return true;
		}
		return false;
	}

	private boolean isFruitBasketEmpty(int fruitForBuying) {

		if (fruitToBuy > 0) {
			return true;
		}
		return false;

//		boolean result = false;
//		result = fruists[fruitForBuying] == 0;
//		if (result) {
//			return true;
//		}
//		return false;
	}

	private void buyFruit(int fruitToBuy2) {
		System.out.println(this.getName() + " buying the  fruit " + getNameOfFruit(fruitToBuy2));
		int ramdonAmountToBuy = 10_000_000;
		for (int i = 0; i < ramdonAmountToBuy; i++) {
			fruists[fruitToBuy2]++;
		}

		 longTask(1000);
	}

	public String getNameOfFruit(int index) {

		switch (index) {
		case APPLE:
			// code to be executed if expression matches value1
			return "APPLE";
		case PEAR:
			// code to be executed if expression matches value2
			return "PEAR";
		case BLACKBERRY:
			// code to be executed if expression matches value3
			return "BLACKBERRY";
		case MANGO:
			// code to be executed if expression matches value3
			return "MANGO";
		case GUAVA:
			// code to be executed if expression matches value3
			return "GUAVA";
		// more cases...
		default:
			// code to be executed if expression doesn't match any case
			return "NOT FRUIT SELECTED";
		}
	}

	private void checkRefigarator() {
		fruitToBuy++;
		// longTask(300);
	}

	private void longTask(int time) {

		try {
			Thread.sleep(time); // time spent searching
			System.out.println(this.getName() + " checking refrigarator ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
