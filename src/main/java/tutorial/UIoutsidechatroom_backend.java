package tutorial;

import Storage.UserStorageUseCase;

import java.util.ArrayList;

public class UIoutsidechatroom_backend {

    public UIoutsidechatroom_backend(){
        //initlaizer
    }

    public ArrayList<Chatroom> getchatroomlst(User user){
        return user.get_user_chatroom();
        //return the chatrooms this user has joined in a lst
    }

    public ArrayList<User> getuserfriends(User user){
        return user.get_user_friends();
        //return this user's all friend in a lst
    }
}
