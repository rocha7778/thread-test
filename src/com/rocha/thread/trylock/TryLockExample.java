package com.rocha.thread.trylock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // Creamos dos hilos que intentar�n adquirir el candado
        Thread thread1 = new Thread(() -> {
            acquireLock();
        });

        Thread thread2 = new Thread(() -> {
            acquireLock();
        });
        
        Thread thread3 = new Thread(() -> {
            acquireLock();
        });

        // Iniciamos los hilos
        thread1.start();
        thread2.start();
        thread3.start();
        
        thread1.join();
        thread2.join();
        thread3.join();
        
        System.out.println("Fin del programa principal");
    }

    public static void acquireLock() {
        // Intentamos adquirir el candado
        if (lock.tryLock()) {
            try {
                // El hilo adquiri� el candado
                System.out.println(Thread.currentThread().getName() + " adquiri� el candado");
                Thread.sleep(2000); // Simulamos alguna operaci�n
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Liberamos el candado
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " liber� el candado");
            }
        } else {
            // El candado est� siendo utilizado por otro hilo
            System.out.println(Thread.currentThread().getName() + " no pudo adquirir el candado");
        }
    }
}

