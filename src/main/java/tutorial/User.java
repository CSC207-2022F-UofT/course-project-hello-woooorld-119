package tutorial;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.sql.Timestamp;

public class User {
    private String displayName;
    private final int id;
    private ArrayList<Chatroom> listofChatroom;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private ArrayList<Timestamp> loginTracker;

    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param id the User's id as assigned when the User is created
     */

    public User(String displayName, int id, String username, String password) {
        this.displayName = displayName;
        this.id = id;
        this.listofChatroom = new ArrayList<Chatroom>();
        this.friendsList = new ArrayList<User>();
        this.username = username; //need to determine username and ensuring it does not already exist in the storage//
        this.password = password;
        this.loginTracker = new ArrayList<>();

    }

    public void addUserToChatroom(Chatroom group){

    }

    public void addUserToFriendList(User friend){

    }

    public void removeUserFromFriendList(User friend){

    }
    // Setter username and getter username

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    // Setter of loginTracker and getter of loginTacker

    public void setLoginTracker(ArrayList<Timestamp>loginTracker){
        this.loginTracker = loginTracker;
    }

    // Setter username and getter username

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
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


}

