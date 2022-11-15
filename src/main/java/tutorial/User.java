package tutorial;

import java.util.ArrayList;
import java.util.List;
public class User {
    private String displayName;
    private final int id;
    private ArrayList<Chatroom> listofChatroom;
    private ArrayList<User> friendsList;

    /**
     * Construct a User
     *
     * @param displayName the User's name as seen by other Users
     * @param id the User's id as assigned when the User is created
     */

    public User(String displayName, int id) {
        this.displayName = displayName;
        this.id = id; //need to determine how we will be creating id and ensuring it does not already exist //
        this.listofChatroom = new ArrayList<Chatroom>();
        this.friendsList = new ArrayList<User>();
    }

    public void addUserToChatroom(Chatroom group){

    }

    public void addUserToFriendList(User friend){

    }

    public void removeUserFromFriendList(User friend){

    }


}
