package com.rocha.thread.semaphore;

public class SemaphoreUnitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for( int i=1; i<=10; i++) {
			new ShemaphoreTest("Cellphone " + i).start();
		}

	}

}
