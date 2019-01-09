package com.justcrud.demo;

public class ThreadLocalTest {

	  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	  static class MyRunnable implements Runnable {
		  
		  

		    @Override
		    public void run() {
		        threadLocal.set((int) (Math.random() * 100D));
		        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		    }
		}

	    public static void main(String[] args) throws InterruptedException {
	        Thread t1 = new Thread(new MyRunnable(), "A");
	        Thread t2 = new Thread(new MyRunnable(), "B");
	        t1.start();
	        t2.start();
	        t1.join();
	        t2.join();
	    }

}

