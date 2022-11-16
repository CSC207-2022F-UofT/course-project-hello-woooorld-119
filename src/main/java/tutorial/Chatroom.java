package tutorial;

import java.util.ArrayList;

public class Chatroom {
    private String name;
    private ArrayList<String> user_list; // list of unique usernames of the users in the chatroom
    private User admin; // User who created the chatroom
    public Chatroom(String name, User admin) {
        this.name = name;
        this.user_list = new ArrayList<>();
        this.admin = admin;

        this.user_list.add(admin.getUsername());
    }

    public void AddUser(String username){
        this.user_list.add(username);
    }

    public void RemoveUser(String username){
        this.user_list.remove(username);
        if (user_list.size() == 0){
            // code to delete chatroom from storage
        }

    }


    public String getName(){
        return this.name;
    }
    public void setName(String new_name){
        this.name = new_name;
    }
    public User getAdmin(){
        return this.admin;
    }

    public void setAdmin(User user_object){
        this.admin = user_object;
    }

    // to be done after storage is created
    public void setMessages(){
        // set up the Chatroom with all the messages from ChatroomStorage //
    }

    public void addMessage(){
        // add message to ChatroomStorage
    }

}
