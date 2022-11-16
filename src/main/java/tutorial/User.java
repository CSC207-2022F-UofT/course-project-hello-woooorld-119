package tutorial;

import java.util.ArrayList;
import java.util.List;
public class User {
    private String displayName;
    private final int id;
    private ArrayList<String> listofChatroom;
    private ArrayList<String> friendsList;
    private String username;

    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param id the User's id as assigned when the User is created
     * @param username the User's username only accessible by the User themself
     */

    public User(String displayName, int id, String username) {
        this.displayName = displayName;
        this.id = id; //need to determine how we will be creating id and ensuring it does not already exist //
        this.username = username;
        this.listofChatroom = new ArrayList<String>();
        this.friendsList = new ArrayList<String>();
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

    public String getUsername(){
        return this.username;
    }

    public ArrayList<String> getListofChatroom(){
        return this.listofChatroom;
    }

    public ArrayList<String> getFriendsList(){
        return this.friendsList;
    }
}
