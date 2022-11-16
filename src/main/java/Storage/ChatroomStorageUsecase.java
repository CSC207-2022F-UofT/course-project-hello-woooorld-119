package Storage;

import com.google.gson.Gson;
import tutorial.Chatroom;

import java.util.List;

public class ChatroomStorageUsecase {
    private String name;

    public ChatroomStorageUsecase(String name) {
        this.name = name;
    }

//    public Chatroom Recreate() {
//        Storage chatroom_storage = new ChatroomStorage(this.name);
//
////        Gson gson = new Gson();
////        ChatroomsInfo information = gson.fromJson(chatroom_storage.readfile(), ChatroomsInfo.class);
////
////        Chatroom chatroom = new Chatroom(information.name, information.adminUser);
////
////        for (String person : information.users) {
////            chatroom.AddUser(person);
////        }
////
////        for (String message : information.messages) {
////            chatroom.setMessage(message);
////        }
////
////        return chatroom;
////        return new Chatroom();
//    }

    public void Save(List<String> messages, String adminuser) {

    }
}
