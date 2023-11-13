package com.rocha.thread.race.condition;

public class RaceConditionTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Shopper[] shoppers = new Shopper[10];
		for (int i = 0; i < shoppers.length / 2; i++) {
			shoppers[2 * i] = new Shopper("Barron-" + i);
			shoppers[2 * i + 1] = new Shopper("Olivia-" + i);
		}
		for (Shopper shopper : shoppers) {
			shopper.start();
		}

		for (Shopper shopper : shoppers) {
			shopper.join();
		}
		
		System.out.println("We need to buy " + Shopper.bagsOfChips + " bags of chips.");

	}
}
