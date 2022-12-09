package tutorial;

import Messages.Message;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;
=======


import java.util.ArrayList;
import java.util.Objects;

public class Chatroom {
    private String name;
    private ArrayList<String> user_list; // list of unique usernames of the users in the chatroom
    private String admin_name; // User who created the chatroom

    private ArrayList<String> message_list; // list of messages in the chatroom

    public Chatroom(String name, String admin_name) {
        this.name = name;
        this.user_list = new ArrayList<>();
        this.admin_name = admin_name;
        this.user_list.add(admin_name);
        this.message_list = new ArrayList<>();
    }

    public ArrayList<String> getMessage(){
        return this.message_list;
    }

    public ArrayList<String> getUserLst(){
        return this.user_list;
    }

    public void AddUser(String username){
        this.user_list.add(username);
    }

    public void RemoveUser(String username){
        this.user_list.remove(username);
    }

=======
    private ArrayList<User> userList; // list of unique user objects of the users in the chatroom
    private User admin; // User who created the chatroom

    private ArrayList<Message> messageList; // list of messages in the chatroom

    private final ChatroomStorageGateway gateway; // interface to save chatroom
    public Chatroom(String name, User admin, ChatroomStorageGateway gateway) {
        this.name = name;
        this.userList = new ArrayList<>();
        this.admin = admin;
        this.userList.add(admin);
        this.messageList = new ArrayList<>();
        this.gateway = gateway;
        this.gateway.saveData(this);
    }

    public void addUser(User newUser){
        this.userList.add(newUser);
        this.gateway.saveData(this);
    }

    public void removeUser(User toBeRemoved){
        if (Objects.equals(toBeRemoved.getUsername(), this.getAdmin().getUsername())){
            this.admin = null;
        }
        this.userList.remove(toBeRemoved);
        this.gateway.saveData(this);
    }

    public ArrayList<User> getUserList(){
        return this.userList;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
        this.gateway.saveData(this);
    }
    public User getAdmin (){
        return this.admin;
    }

    public void addMessage(String message_to_add){
        this.message_list.add(message_to_add);
=======
    public void setAdmin(User newAdmin){
        this.admin = newAdmin;
        this.gateway.saveData(this);
    }

    public void addMessage(Message messageToAdd){
        this.messageList.add(messageToAdd);
        this.gateway.saveData(this);
    }

}
