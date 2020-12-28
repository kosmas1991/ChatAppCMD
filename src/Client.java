import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",7070);
        System.out.println("Connected to server");
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Thread inputStreamThread = new Thread(new InputRunnable(input));
        Thread outputStreamThread = new Thread(new OutputRunnable(output));
        inputStreamThread.start();
        outputStreamThread.start();

        try {
            inputStreamThread.join();
            outputStreamThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
