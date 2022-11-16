package tutorial;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.Timestamp;

public class User {
    private String displayName;
    private final int id;
    private ArrayList<String> listofChatroom;
    private ArrayList<String> friendsList;
    private String username;
    private String password;
    private ArrayList<Timestamp> loginTracker;

    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param id the User's id as assigned when the User is created
     * @param username the User's username only accessible by the User themself
     */

    public User(String displayName, int id, String username, String password) {
        this.displayName = displayName;
        this.id = id; //need to determine how we will be creating id and ensuring it does not already exist //
        this.username = username;
        this.listofChatroom = new ArrayList<String>();
        this.friendsList = new ArrayList<String>();
        this.password = password;
        this.loginTracker = new ArrayList<>();
    }

    public void addUserToChatroom(String chatroom_name){
        // chatroom.adduser()
        this.listofChatroom.add(chatroom_name);
    }

    public void addUserToFriendList(String friend_username){
        this.friendsList.add(friend_username);
    }

    public void removeUserFromFriendList(String friend_username){
        this.friendsList.remove(friend_username);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<String> getListofChatroom(){
        return this.listofChatroom;
    }

    public ArrayList<String> getFriendsList(){
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
