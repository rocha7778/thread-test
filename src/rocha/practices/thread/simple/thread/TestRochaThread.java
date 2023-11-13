package rocha.practices.thread.simple.thread;

public class TestRochaThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Counter rochaCounter = new Counter("Rocha");
		Counter paolaCounter = new Counter("Paola");
		Counter carlosCounter = new Counter("Carlos");
		Counter miguelCounter = new Counter("Miguel");
		
		rochaCounter.start();
		paolaCounter.start();
		carlosCounter.start();
		miguelCounter.start();
		
		rochaCounter.join();
		paolaCounter.join();
		carlosCounter.join();
		miguelCounter.join();
		
		Counter.printTotalCounter();
	}

}
