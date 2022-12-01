package tutorial;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.Timestamp;

public class User {
    private String displayName;
    private ArrayList<Chatroom> listofChatroom;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private ArrayList<Timestamp> loginTracker;

    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param username the User's username only accessible by the User themself
     */

    public User(String displayName, String username, String password) {
        this.displayName = displayName;
        this.username = username;
        this.listofChatroom = new ArrayList<Chatroom>();
        this.friendsList = new ArrayList<User>();
        this.password = password;
        this.loginTracker = new ArrayList<>();
    }

    public void addUserToChatroom(Chatroom chatroom_name){
        // chatroom.adduser()
        this.listofChatroom.add(chatroom_name);
    }

    public void addUserToFriendList(User friend){
        this.friendsList.add(friend);
    }

    public void removeUserFromFriendList(User friend){
        this.friendsList.remove(friend);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Chatroom> getListofChatroom(){
        return this.listofChatroom;
    }

    public ArrayList<User> getFriendsList(){
        return this.friendsList;
    }

    // Setter of loginTracker and getter of loginTacker

    public void setLoginTracker(ArrayList<Timestamp>loginTracker){
        this.loginTracker = loginTracker;
    }

    public ArrayList<Timestamp>getLoginTracker(){
        return loginTracker;
    }

    // Method to update login tracker

    public void updateLoginTracker(Timestamp timing){
        loginTracker.add(timing);
    }
}
