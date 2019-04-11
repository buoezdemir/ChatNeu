package application;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) {
		
			try {
			ServerSocket server = new ServerSocket(5555);
			System.out.println("Server wird gestartet");
			Socket s = server.accept();
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String string = null;
			while((string = br.readLine()) != null)
			{
				writer.write(string + "\n");
				writer.flush();
				System.out.println("Empfangen von Client:" + string);
			}
			
			writer.close();
			br.close();
			
			
			//hallotest

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
