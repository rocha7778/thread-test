package rocha.practices.thread.semaphore;

public class TestSemaphoreMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TestSemaphore rochaCounter = new TestSemaphore("Rocha");
		TestSemaphore paolaCounter = new TestSemaphore("Paola");
		TestSemaphore carlosCounter = new TestSemaphore("Carlos");
		TestSemaphore miguelCounter = new TestSemaphore("Miguel");
		
		rochaCounter.start();
		paolaCounter.start();
		carlosCounter.start();
		miguelCounter.start();
		
//		rochaCounter.join();
//		paolaCounter.join();
//		carlosCounter.join();
//		miguelCounter.join();
		
		
		TestSemaphore.printTotalCounter();

	}

}
