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

    public void AddUser(int userid){
        this.UserList.add(userid);
    }

    public void RemoveUser(int userid){
        this.UserList.remove(userid);
        if (UserList.size() == 0){
            // code to delete chatroom from storage
        }

    }

    public void setMessages(){
        // set up the Chatroom with all the messages from ChatroomStorage //
    }

}
