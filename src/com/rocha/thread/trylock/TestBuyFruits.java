package com.rocha.thread.trylock;

import java.text.Format;
import java.text.NumberFormat;

public class TestBuyFruits {

	public static void main(String[] args) throws InterruptedException {
		
		Thread rocha = new BuyerFruist("Rocha");
		Thread paola = new BuyerFruist("Paola");
		Thread carlos = new BuyerFruist("Carlos");
		
		rocha.start();
		paola.start();
		carlos.start();
		rocha.join();
		paola.join();
		carlos.join();
		
		
		Format format = NumberFormat.getInstance();
		

		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Amount bougth per fruit");
		for (int i = 0; i < 5; i++) {
			System.out.println("[" + ((BuyerFruist)(rocha)).getNameOfFruit(i) + "] " + format.format(BuyerFruist.fruists[i]));
		}
		
		
		System.out.println("total fruit bougth: " + format.format(BuyerFruist.numberFruitsToBuy));
		System.out.println("Termino el programa principal");
		
		
		
		

	}

}
