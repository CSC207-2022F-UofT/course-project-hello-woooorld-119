package tutorial;

public class AddMessage extends MessagesStorage {
    public AddMessage(String Chatroom.name) {

        super("storage/messages/" + Chatroom.name + ".txt");
    }

    public void add(String message) {
        super.writefile(message);
    }

    public String readfile() {
        return super.readfile();
    }
}