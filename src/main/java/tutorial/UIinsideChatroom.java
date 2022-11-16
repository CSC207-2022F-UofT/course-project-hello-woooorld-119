package tutorial;
import tutorial.Chatroom;
import tutorial.User;
import tutorial.UIinsidechatroom_backend;


public class UIinsideChatroom {
    private Chatroom chatroom;

    public void display_current_chatroom(){
        //displays the current chatroom
        display_member_lst();
        send_message_textbox();
        send_messaage_button();
        upload_picture_button();
    }

    public void display_member_lst(){
        //display this chatroom's member list
        //make every member displays as button, so click in opens that user's public profile page
        UIinsidechatroom_backend a = null;
        for (User b: a.getmemberlst(this.chatroom)){
            //creates the user icon, along with the functionality of clicking in to their public profile
            this.create_public_profile_button(b);
        }

    }

    public void send_message_textbox(){
        //sends the string inputted and clears it after successfully sent
    }

    public void send_messaage_button(){
        //sends the message
    }

    public void upload_picture_button(){
        //calls to first select a picture from device and then uploads it
    }

    public void create_public_profile_button(User user){
        //create a GUI page after clicking the edit public profile button
    }

    public static void main(String[] args) {
    }

}
