package application;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
		ExecutorService executor = Executors.newFixedThreadPool(30);
		ServerSocket server;
		
		try {
			server = new ServerSocket(5552);
			System.out.println("Server wird gestartet");
			
			while(true)
			{
				try {
				
				Socket client = server.accept();
				executor.execute(new Handler(client));
				//hallotest

				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e1) {
				e1.printStackTrace();
			}
		
		
			}
		}

		
		
	
