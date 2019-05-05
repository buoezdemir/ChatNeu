package application;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.lang.*;



public class Thread {
	
	static class Zaehlen implements Runnable {

		@Override
		public void run() {
	
			
			for (int i = 0; i<10; i++)
			{
				System.out.println(java.lang.Thread.currentThread().getName() + " zählt: " + i);
				try {
				new java.lang.Thread();
				java.lang.Thread.sleep(600);
			} catch(InterruptedException e)
				{
				e.printStackTrace();
				}
			}
			
		}
		
		
	}

	public static void main (String[] args)
	{
		 
		 System.out.println("--------START--------");
		 
		 ExecutorService executor = Executors.newFixedThreadPool(2);
	
		 
		 java.lang.Thread t1 = new java.lang.Thread(new Zaehlen());
		 java.lang.Thread t2 = new java.lang.Thread(new Zaehlen()); 
		 
		 //Namen
		 t1.setName("Erster");
		 t2.setName("Zweiter");
		 
		 //Start
		 
		 executor.execute(t1);
		 executor.execute(t2);
		 executor.shutdown();
		 
		 try {
			 //Wartezeit
			while(!executor.awaitTermination(600, TimeUnit.MILLISECONDS))
			{
				System.out.println("Das Zählen läuft noch!");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("--------ENDE---------");
	}



	
}
