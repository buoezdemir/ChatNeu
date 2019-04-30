package application;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler implements Runnable {

	private Socket client;
	
	public Handler(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
	OutputStream out = client.getOutputStream();
	PrintWriter writer = new PrintWriter(out);
	
	InputStream in = client.getInputStream();
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
	
	client.close();
	//hallotest

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
