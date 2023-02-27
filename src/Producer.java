import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class Producer extends Thread {

    private Buffer<MessageProducer> prodBuffer;
    private Buffer<Message> messageBuffer;

    public Producer(Buffer<MessageProducer> prodBuffer, Buffer<Message> messageBuffer)  {
        this.prodBuffer = prodBuffer;
        this.messageBuffer = messageBuffer;
    }

    public void run() {
        Message message;
        while(!Thread.interrupted()) {
            try {
                message = buffer.get();
                viewer.setMessage(message);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
