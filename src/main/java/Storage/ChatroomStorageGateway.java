package Storage;

import tutorial.Chatroom;

//use case
public interface ChatroomStorageGateway {
    Chatroom getData();
    void saveData(Chatroom new_chatroom);

}
