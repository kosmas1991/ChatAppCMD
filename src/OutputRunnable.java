import java.io.IOException;
import java.io.PrintWriter;

public class OutputRunnable  implements Runnable{
    PrintWriter output;

    public OutputRunnable(PrintWriter output) {
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            try {
                output.println((char)System.in.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
