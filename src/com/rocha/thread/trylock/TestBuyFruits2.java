package com.rocha.thread.trylock;

public class TestBuyFruits2 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread rocha = new BuyerFruist2("Rocha");
		Thread paola = new BuyerFruist2("Paola");
		Thread carlos = new BuyerFruist2("Carlos");
		
		rocha.start();
		paola.start();
		carlos.start();
		
		rocha.join();
		paola.join();
		carlos.join();
		
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("[" + ((BuyerFruist2)(rocha)).fruists[i] + "] " );
		}
		

	}

}
