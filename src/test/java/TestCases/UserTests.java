package TestCases;

import Storage.ChatroomStorageUsecase;
import org.junit.jupiter.api.Test;
import tutorial.Chatroom;
import tutorial.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    // User with no chatroom's
    @Test
    void testgetListofChatroomEmpty() {
        User martin = new User("MART", "martin", "password123");
        ArrayList<Chatroom> expected = new ArrayList<>();
        assertEquals(expected, martin.getListofChatroom());
    }

    @Test
    void testgetListofChatroom() {
        User martin = new User("MART", "martin", "password123");
        ArrayList<Chatroom> expected = new ArrayList<>();
        assertEquals(expected, martin.getListofChatroom());
    }
    @Test
    void testaddUserToChatroom() {
        User martin = new User("MART", "martin", "password123");
        Chatroom cscgroup = new Chatroom("CSCgroup", martin, new ChatroomStorageUsecase("hello"));
        ArrayList<Chatroom> expected = new ArrayList<>();
        expected.add(cscgroup);
        martin.addUserToChatroom(cscgroup);
        assertEquals(expected, martin.getListofChatroom());
    }

    @Test
    void testaddUserToFriendList(){
        User martin = new User("MART", "martin", "password123");
        User luther = new User("Lulu", "luther200", "200password");
        User clark = new User("Superman", "ClarkKent", "IamSuperman");
        martin.addUserToFriendList(luther);
        martin.addUserToFriendList(clark);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(luther);
        expected.add(clark);
        assertEquals(expected, martin.getFriendsList());
    }


    @Test
    void testremoveUserFromFriendList(){
        User martin = new User("MART", "martin", "password123");
        User luther = new User("Lulu", "luther200", "200password");
        User clark = new User("Superman", "ClarkKent", "IamSuperman");
        martin.addUserToFriendList(luther);
        martin.addUserToFriendList(clark);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(luther);
        expected.add(clark);
        martin.removeUserFromFriendList(luther);
        expected.remove(luther);
        assertEquals(expected, martin.getFriendsList());
    }
}
