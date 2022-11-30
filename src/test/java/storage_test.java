import Storage.Chatrooms.ChatroomStorage;
import Storage.Chatrooms.ChatroomStorageUsecase;
import org.junit.jupiter.api.Test;
import tutorial.Chatroom;

import static org.junit.jupiter.api.Assertions.*;

class storage_test {
    @Test
    void create() {
        ChatroomStorageUsecase cs = new ChatroomStorageUsecase("i");
        Chatroom c = new Chatroom("name", "admin");

        cs.saveData(c);

        assertTrue(cs.getData().getName().equals("name"));
    }
}
