package application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
	
	private static int  a;
	
	public static void main(String[] args) {
		a=1;
		
		new Thread(new Client()).start();
	}
	
	public void run() {
		try {
			Socket s = new Socket("localhost", 5553);
			System.out.println("Client wird gestartet");
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			
			System.out.println("Eingabe:");
			writer.write("Hallo vom " + a ". Client\n");
			writer.flush();
			
			String string = null;
			while((string = br.readLine()) != null)
			{
				writer.write(string);
				writer.flush();
				System.out.println("Empfangen von Server:" + string);
			}
			
			br.close();
			writer.close();
			
			//test
			}
		catch(Exception e){
			
		}
		}
		
	}
		
}