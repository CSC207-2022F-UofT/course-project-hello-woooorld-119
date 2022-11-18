package tutorial;

import java.util.ArrayList;

public class DirectMessage{
    private int id;

    private String name;
    private AdminUser admin;

    private ArrayList<User> UserList;

    public DirectMessage(String name, int id, AdminUser admin) {
        this.name = name;
        this.id = id;
        this.admin = null;
    }
    public void AddUser(User username){
        this.UserList.add(username);
    }

    public void DM(User user1, User user2){
        this.AddUser(user1);
        this.AddUser(user2);
        this.admin = new AdminUser(user1.getName(), user1.getID());
    }
}


