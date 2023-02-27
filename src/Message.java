
import javax.swing.*;
import java.io.Serializable;


public class Message implements Serializable {
    private ImageIcon icon;
    private String text;

    Message(String text, ImageIcon icon){
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }
    public Icon getIcon(){
        return icon;
    }
}
