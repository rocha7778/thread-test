package com.rocha.thread.productor.consumidor;

import java.util.concurrent.BlockingQueue;

public class Consumidor extends Thread{
	
	private BlockingQueue<String> queue;

	public Consumidor(String name, BlockingQueue<String> queue) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
            try {
                String bowl = (String)queue.take();
                if (bowl == "no soup for you!")
                    break;
                
                System.out.format("Ate %s\n", bowl);
                Thread.sleep(300); // time to eat a bowl of soup
             } catch (Exception e) { e.printStackTrace(); }
        }
	}

}
