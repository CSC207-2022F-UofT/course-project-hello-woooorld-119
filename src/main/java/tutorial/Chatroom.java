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


}
