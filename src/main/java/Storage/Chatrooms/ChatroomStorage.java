package Storage.Chatrooms;

import Storage.Storage;

public class ChatroomStorage extends Storage {
    public ChatroomStorage(String name) {
        super("storage/chatrooms/" + name + ".txt");  // this accesses inside the chatrooms folder
    }

    @Override
    public void writefile(String text) {
        super.writefile(text);
    }

    @Override
    public String readfile() {
        return super.readfile();
    }
}
