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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {


	public static void main(String[] args) throws Exception {
		ServerSocket server;
		ExecutorService executor = Executors.newFixedThreadPool(30);
		try {
			server = new ServerSocket(5553);
			System.out.println("Server wird gestartet");
			
			while(true)
			{
				try {
				
				Socket client = server.accept();
				executor.execute(new Handler(client));
				//hallotest

				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
			}
		}

		
		
	
