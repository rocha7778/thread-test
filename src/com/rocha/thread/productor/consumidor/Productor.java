package com.rocha.thread.productor.consumidor;

import java.util.concurrent.BlockingQueue;

public class Productor extends Thread {
	
	
	private BlockingQueue<String> queue;

	public Productor(String name, BlockingQueue<String> queue) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) { // serve 20 bowls of soup
            try {
            	queue.add("Bowl #" + i);
                System.out.format("Served Bowl #%d - remaining capacity: %d\n", i, queue.remainingCapacity());
                Thread.sleep(200); // time to serve a bowl of soup
            } catch (Exception e) { e.printStackTrace(); }
        }
		queue.add("no soup for you!");
		queue.add("no soup for you!");
	}

}
