package tutorial;

import java.util.ArrayList;
import tutorial.User;

public class DirectMessage{
    private int id;

    private String name;
    private User adminuser;
    private User user;

    private ArrayList<User> UserList;

    public DirectMessage(User adminuser, User user) {
        this.adminuser = adminuser;
        this.user = user;
    }

    //create a chatroom with two user, make admin user the admin, store it in Storage using storage gateway.
    //Joptionpane to input from user
    public void AddUser(User username){
        this.UserList.add(username);
    }

    public void DM(){

    }
}


