package TestCases;
import Storage.Accounts.AccountsStorageUseCase;
import Storage.Chatrooms.ChatroomStorageUsecase;
import Storage.Users.UserStorageUseCase;
import org.junit.jupiter.api.Test;
import tutorial.Chatroom;
import tutorial.User;
import static org.junit.jupiter.api.Assertions.*;

public class StorageTests {

    @Test
    void create() {
        ChatroomStorageUsecase cs = new ChatroomStorageUsecase("name");
        Chatroom c = new Chatroom("name", "admin");
        cs.saveData(c);
        assertTrue(cs.getData().getName().equals("name"));
    }

    @Test
    void user_storage () {
        UserStorageUseCase us = new UserStorageUseCase("username");
        User new_user = new User("chicken", "username", "password");
        us.saveData(new_user);
        assertTrue(us.getData().getUsername().equals("username"));
    }

    @Test
    void accounts_storage() {
        AccountsStorageUseCase ac = new AccountsStorageUseCase();
        ac.save("hi", "hello");
        assertTrue(ac.usernameExists("hi"));
        assertTrue(ac.passwordExists("hi", "hello"));
    }
}
