package tutorial;
import tutorial.Chatroom;
import tutorial.User;
import tutorial.UIoutsidechatroom_backend;

public class UIoutsideChatroom {
    private User user;

    public void display(){
        //displays the information to GUI
        display_friend_lst();
        display_chatrooms();
        create_chatroom_button();
        enter_public_profile_button();
        enter_private_profile_button();
    }

    public void create_enter_chatroom_button(Chatroom chatroom){
        //create a GUI button to enter this chatroom
    }

    public void display_chatrooms(){
        //displays the chatroom with their icon picture
        UIoutsidechatroom_backend obj = null;
        for (Chatroom chatroom: obj.getchatroomlst(this.user)){
            this.create_enter_chatroom_button(chatroom);
        }
    }

    public void display_friend_lst(){
        //display this user's friendlist
        UIoutsidechatroom_backend obj = null;
        for (User friend: obj.getuserfriends(this.user)){
            this.enter_friend_public_profile_button(friend);
        }
    }

    public void create_chatroom_button() {
        //create a GUI button to create chatroom, with current user being the admin user
        //and store the information back to storage\

    }

    public void enter_friend_public_profile_button(User user){
        //creates an icon when clicked, you can go into that user's public profile
    }

    public void enter_public_profile_button(){
        //create a GUI page after clicking the edit public profile button
    }

    public void enter_private_profile_button(){
        //create a GUI page after clicking the edit private profile button
    }

    public static void main(String[] args) {
    }

}
