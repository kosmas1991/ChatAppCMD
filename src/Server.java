import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7070);
        System.out.println("Waiting for clients");
        int counter = 1;
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + counter + " connected");
            Thread threadClient = new Thread(new ThreadClient(socket));
            threadClient.start();
        }
    }
}
