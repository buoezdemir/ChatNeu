package application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 5555);
			System.out.println("Client wird gestartet");
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			writer.write("Hallo\n");
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