import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClient implements Runnable {
    Socket socket;
    PrintWriter output;
    BufferedReader input;

    public ThreadClient(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(socket.getOutputStream(),true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
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
