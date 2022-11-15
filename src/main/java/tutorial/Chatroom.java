package tutorial;

import java.util.ArrayList;

public class Chatroom {

    private int id;
    private String name;
    private ArrayList<Integer> UserList; // list of unique IDs of the users in the chatroom
    private AdminUser admin; // User who created the chatroom
    public Chatroom(String name, int id, AdminUser adminid) {
        this.name = name;
        this.id = id;
        this.UserList = new ArrayList<>();
        // this.admin references the creating user of the chatroom //
    }

    public Chatroom(String name, String adminUser) {
        //constructor like this?
    }

    public void AddUser(String userid){
        this.UserList.add(userid);
    }

    public void RemoveUser(String serid){
        this.UserList.remove(userid);
        if (UserList.size() == 0){
            // code to delete chatroom from storage
        }

    }

    public void setMessage(String message){
        // set up the Chatroom with all the messages from ChatroomStorage //
    }

}
