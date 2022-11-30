import org.junit.jupiter.api.Test;
import tutorial.Chatroom;
import tutorial.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class UserTests {

    @Test
    void testgetListofChatroom() {
        User martin = new User("MART", "martin", "password123");
        ArrayList<String> expected = martin.getListofChatroom();
        assertEquals(expected, martin.getListofChatroom());
    }

//    @Test
//    void testaddUserToChatroom(User martin) {
//        ArrayList<String> expected = new ArrayList<String>();
//        expected.add("CSCrocks");
//        martin.addUserToChatroom("CSCrocks");
//        assertEquals(expected, martin.getListofChatroom());
//    }

// Test cases
    //length (0, 1, 5)
}