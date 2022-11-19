package Storage;

import tutorial.Chatroom;

import java.util.ArrayList;

public class ChatroomStorageJ {
    Storage chatroom_storage;
    public ChatroomStorageJ() {
        this.chatroom_storage = new Storage("storage/chatrooms");
    }

    public ArrayList<Chatroom> getChatrooms() {
        ArrayList<String> chatroom_names = chatroom_storage.getfiles();

        System.out.println(chatroom_names);

        ArrayList<Chatroom> output = new ArrayList<Chatroom>();

        for (String s: chatroom_names) {
            output.add(new ChatroomStorageUsecase(s).getData());
        }

        return output;
    }
}
