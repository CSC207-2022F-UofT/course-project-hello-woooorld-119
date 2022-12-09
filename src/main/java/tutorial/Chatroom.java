package tutorial;

import Messages.Message;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;

import java.util.ArrayList;
import java.util.Objects;

public class Chatroom {
    private String name;
    private ArrayList<String> userList; // list of unique usernames of the users in the chatroom
    private String admin; // User who created the chatroom
    private ArrayList<Message> messageList; // list of messages in the chatroom
    private final ChatroomStorageGateway gateway; // interface to save chatroom
    
    public Chatroom(String name, String admin, ChatroomStorageGateway gateway) {
        this.name = name;
        this.userList = new ArrayList<>();
        this.admin = admin;
        this.userList.add(admin);
        this.messageList = new ArrayList<>();
        this.gateway = gateway;
        this.gateway.saveData(this);
    }

    public void addUser(String newUser){
        this.userList.add(newUser);
        this.gateway.saveData(this);
    }


    public void removeUser(String toBeRemoved){
        if (Objects.equals(toBeRemoved, this.getAdmin())){
            this.admin = null;
        }
        this.userList.remove(toBeRemoved);
        this.gateway.saveData(this);
    }

    public ArrayList<String> getUserList(){
        return this.userList;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
        this.gateway.saveData(this);
    }
    
    public String getAdmin (){
        return this.admin;
    }

    public void setAdmin(String newAdmin){
        this.admin = newAdmin;
        this.gateway.saveData(this);
    }

    public void addMessage(Message messageToAdd){
        this.messageList.add(messageToAdd);
        this.gateway.saveData(this);
    }

}