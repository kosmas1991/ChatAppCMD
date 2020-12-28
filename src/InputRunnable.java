import java.io.BufferedReader;
import java.io.IOException;

public class InputRunnable implements Runnable{
    BufferedReader input;

    public InputRunnable(BufferedReader input) {
        this.input = input;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.print(input.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
