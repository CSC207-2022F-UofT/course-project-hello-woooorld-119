package tutorial;
import tutorial.Chatroom;
import Storage.UserStorageUseCase;

import java.util.ArrayList;

public class UIinsidechatroom_backend{


    public UIinsidechatroom_backend(){
        //initlaizer
    }
    public ArrayList<String> getmember_lst(Chatroom chatroom){
        return chatroom.getUserLst();
        //return the list of the users in this chatroom

    }
}
