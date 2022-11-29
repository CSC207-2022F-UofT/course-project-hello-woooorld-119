package tutorial;

import Messages.Message;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;

import java.util.ArrayList;

public class Chatroom {
    private String name;
    private ArrayList<String> user_list; // list of unique usernames of the users in the chatroom
    private String admin_name; // User who created the chatroom

    private ArrayList<Message> message_list; // list of messages in the chatroom

    private ChatroomStorageGateway gateway; // interface to save chatroom
    public Chatroom(String name, String admin_name) {
        this.name = name;
        this.user_list = new ArrayList<>();
        this.admin_name = admin_name;
        this.user_list.add(admin_name);
        this.message_list = new ArrayList<>();
        this.gateway = new ChatroomStorageGateway() {

            @Override
            public Chatroom getData() {
                ChatroomStorageGateway chatroom_storage = (ChatroomStorageGateway) new ChatroomStorageUsecase(name);
                return chatroom_storage.getData();
            }
            @Override
            public void saveData(Chatroom new_chatroom) {

            }
        };
        this.gateway.saveData(this);
    }

    public ArrayList<String> getUserLst(){
        return this.user_list;
    }

    public void AddUser(String username){
        this.user_list.add(username);
        this.gateway.saveData(this);
    }

    public void RemoveUser(String username){
        this.user_list.remove(username);
        this.gateway.saveData(this);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String new_name){
        this.name = new_name;
        this.gateway.saveData(this);
    }
    public String getAdmin_name (){
        return this.admin_name;
    }

    public void setAdmin(String new_admin_name){
        this.admin_name = new_admin_name;
        this.gateway.saveData(this);
    }

    public void addMessage(Message message_to_add){
        this.message_list.add(message_to_add);
        this.gateway.saveData(this);
    }

}
