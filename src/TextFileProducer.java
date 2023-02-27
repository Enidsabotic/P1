import javax.swing.*;
import java.io.*;

public class TextFileProducer implements MessageProducer {

    private Message[] messages;
    private int delay = 0;
    private int times = 0;

    private int size = 0;

    private int currentIndex = -1;


    public TextFileProducer(String filename) {


        try (BufferedReader br = new BufferedReader(

                new InputStreamReader
                        (new FileInputStream(filename), "UTF8"))
        ) {

            times = Integer.parseInt(br.readLine());
            delay = Integer.parseInt(br.readLine());
            size = Integer.parseInt(br.readLine());
            messages = new Message[size];
            int i = 0;
            while (br.readLine() != null) {
                messages[i] = new Message(br.readLine(), new ImageIcon(br.readLine()));
                i++;

            }
            br.close();

        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }


    @Override
    public int delay() {
        return delay;
    }

    @Override
    public int times() {
        return times;
    }

    @Override
    public int size() {
        return (messages == null) ? 0 : messages.length;
    }

    @Override
    public Message nextMessage() {
        if (size() == 0)
            return null;
        currentIndex = (currentIndex + 1) % messages.length;
        return messages[currentIndex];
    }
}
