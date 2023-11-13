package com.rocha.thread.productor.consumidor;

import java.util.concurrent.ArrayBlockingQueue;

public class TestProductorConsumidor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
		Productor productor = new Productor("Productor", queue);
		Consumidor consumidor = new Consumidor("Consumidor", queue);
		
		productor.start();
		consumidor.start();
		
		consumidor.join();
		consumidor.join();

	}

}
