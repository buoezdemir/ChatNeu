package application;

import java.io.BufferedReader;
import java.lang.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import application.Thread.Zaehlen;

public class Client implements Runnable  {
	
	private static int  a;
	
	
	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		a=1;
		 java.lang.Thread t1 = new java.lang.Thread(new Client());
		 t1.start();
		 
		
		//new Thread(new Client()).start();
	
	}
	@Override
	public void run() {
		try {
			
			Scanner eingabe = new Scanner(System.in);
			Socket client = new Socket("localhost", 5552);
			System.out.println("Client wird gestartet");
			
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			InputStream in = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			
			System.out.println("Eingabe:");
			String anServer = eingabe.nextLine();
			
			writer.write(anServer + " von " + a +   " . Client\n");
			//writer.write("Hallo vom " + a +". Client\n");
			writer.flush();
			a++;
			
			String string = null;
			while((string = br.readLine()) != null)
			{
				System.out.println("Empfangen von Server: " + string);
				
			}
			
			br.close();
			writer.close();
			
			//test
			}
		catch(IOException e){
			
		}
		}
		
	}
		
