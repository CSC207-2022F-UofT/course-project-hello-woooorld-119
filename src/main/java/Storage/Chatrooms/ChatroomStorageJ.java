package Storage.Chatrooms;

import Storage.Storage;
import tutorial.Chatroom;

import java.util.ArrayList;

public class ChatroomStorageJ {
    Storage chatroomStorage;
    public ChatroomStorageJ() {
        this.chatroomStorage = new Storage("storage/chatrooms");
    }

    public ArrayList<Chatroom> getChatrooms() { //so we can set up a user with all the chatrooms
        ArrayList<String> chatroomNames = chatroomStorage.getfiles();

        ArrayList<Chatroom> output = new ArrayList<Chatroom>();

        for (String s: chatroomNames) {
            output.add(new ChatroomStorageUsecase(s).getData());
        }

        return output;
    }
}
