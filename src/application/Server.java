package application;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) {
		Server server = new Server(8000);
	}

	private int port;

	public Server(int port) {
		super();
		this.port = port;
	}
public void startListening() {
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket remoteClientSocket = serverSocket.accept();
			
			Scanner scan = new Scanner(new Buffered Reader(new InputStreamReader(remoteClientSocket.getInputStream())))
			if(s.hasNextLine()) {
				System.out.println("Nachricht: "+ s.nextLine());
			}
			s.close();
			remoteClientSocket.close();
			ServerSocket.close();
			} catch(Exeption e) {
				e.printStackTrace();
			}
			}

		}
	})
	
}
}