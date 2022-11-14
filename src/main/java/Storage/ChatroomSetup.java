package Storage;

import Chatroom.Chatroom;
import com.google.gson.Gson;

public class ChatroomSetup {
    private String name;

    public ChatroomSetup(String name) {
        this.name = name;
    }

    public Chatroom Recreate() {
        Storage chatroom_storage = new ChatroomStorage(this.name);

        Gson gson = new Gson();
        ChatroomsInfo information = gson.fromJson(chatroom_storage.readfile(), ChatroomsInfo.class);

        Chatroom chatroom = new Chatroom();

        for (String person : information.users) {
            chatroom.addUser(person);
        }

        for (String message : information.messages) {
            chatroom.setMessage(message);
        }

        return chatroom;
    }
}
