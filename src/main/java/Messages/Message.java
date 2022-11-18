package Messages;

import java.util.ArrayList;
import java.util.Arrays;

public class Message {
    String to;
    String from;
    ArrayList<ArrayList<String>> texts; // [[msg, time]]

    public Message(String from, String to) {
        this.to = to;
        this.from = from;
    }

    public void addMessage(String msg, String timestamp) {
        this.texts.add(new ArrayList<String>(Arrays.asList(msg, timestamp)));
    }
}
