import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public void writeObject(String filename, MessageProducer mp) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeInt(mp.times());
            oos.writeInt(mp.delay());
            oos.writeInt(mp.size());
            for (int i = 0; i < mp.size(); i++) {
                oos.writeObject(mp.nextMessage());
            }
            oos.flush();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    public static void main(String[] args) {

        WriteObject wObj = new WriteObject();
        TextFileProducer tfp = new TextFileProducer("files\\new.txt");
        wObj.writeObject("files\\new.dat",tfp);

    }
}
