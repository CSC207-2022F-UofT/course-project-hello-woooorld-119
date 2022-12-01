package tutorial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Storage.ChatroomStorageUsecase;
import tutorial.Chatroom;
import tutorial.User;
import Storage.ChatroomStorage;
import Storage.ChatroomStorageGateway;
import javax.swing.*;

public class DirectMessage{

    private User adminuser;
    private User user;
    private ArrayList<User> userlist;

    public DirectMessage(User adminuser, User user) {
        this.adminuser = adminuser;
        this.user = user;
    }

    public void adduser(){
        this.userlist.add(this.adminuser);
        this.userlist.add(this.user);
    }

    public Chatroom getchatroomname(){
        String display_name = JOptionPane.showInputDialog("Enter nickname for the user");
        Chatroom chatroom = new Chatroom(display_name, this.adminuser.getUserDisplayName());
        chatroom.AddUser(user.getUserDisplayName());
        user.addUserToChatroom(chatroom);
        adminuser.addUserToChatroom(chatroom);
        ChatroomStorageGateway chatroom_storage = (ChatroomStorageGateway) new ChatroomStorageUsecase(display_name);
        chatroom_storage.saveData(chatroom);
        return chatroom;
    }


}


