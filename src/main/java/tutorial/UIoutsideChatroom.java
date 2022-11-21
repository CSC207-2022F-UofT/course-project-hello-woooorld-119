package tutorial;
import Storage.ChatroomStorage;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;
import tutorial.Chatroom;
import tutorial.User;
import tutorial.UIoutsidechatroom_backend;
import tutorial.UIinsideChatroom;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tutorial.UIPublicProfile;
import tutorial.UIPrivateProfile;

public class UIoutsideChatroom {
    private final User user;
    private JFrame frame;
    private final Integer frame_length = 900;
    private final Integer frame_width = 900;
    private final Integer button_width = 900;
    private final Integer button_length = 900;

    public UIoutsideChatroom(User user){
        this.user = user;
    }
    public void display(){
        //displays the information to GUI
        this.frame.setSize(frame_width, frame_length);
        display_friend_lst();
        display_chatrooms();
        create_chatroom_button();
        enter_public_profile_button(this.user);
        enter_private_profile_button(this.user);
    }

    public void create_enter_chatroom_button(Chatroom chatroom){
        //create a GUI button to enter this chatroom
        JButton b = new JButton(chatroom.getName());//creating instance of JButton
        b.setBounds(200,100,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true); //enables the button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIinsideChatroom obj = new UIinsideChatroom();
                obj.display_current_chatroom(); // goes to the UI insidechatroom page
            }
        });
    }

    public void display_chatrooms(){
        //displays the chatroom with their icon picture
        UIoutsidechatroom_backend obj = new UIoutsidechatroom_backend();
        for (Chatroom chatroom: obj.getchatroomlst(this.user)){
            this.create_enter_chatroom_button(chatroom);
        }
    }

    public void display_friend_lst(){
        //display this user's friendlist
        UIoutsidechatroom_backend obj = new UIoutsidechatroom_backend();
        for (User friend: obj.getuserfriends(this.user)){
            this.enter_friend_public_profile_button(friend);
        }
    }

    public void create_chatroom_button() {
        //create a GUI button to create chatroom, with current user being the admin user
        //and store the information back to storage\
        JButton b = new JButton("Create Chatroom");//creating instance of JButton
        b.setBounds(400,400,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            String display_name = JOptionPane.showInputDialog("Enter chatroom name");
            Chatroom chatroom = new Chatroom(display_name, this.user.get_user_display_name());//creates the chatroom
            ChatroomStorageGateway chatroom_storage = (ChatroomStorageGateway) new ChatroomStorageUsecase(display_name);
            chatroom_storage.saveData(chatroom);
        });

    }

    public void enter_friend_public_profile_button(User user){
        //creates an icon when clicked, you can go into that user's public profile
        JButton b = new JButton(user.get_user_display_name());//creating instance of JButton
        b.setBounds(800,100,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            UIPublicProfile obj = new UIPublicProfile(user);
            obj.display(); // goes to the UI insidechatroom page
        });
    }

    public void enter_public_profile_button(User user){
        //create a GUI page after clicking the edit public profile button
        JButton b = new JButton("Edit your public profile");//creating instance of JButton
        b.setBounds(0,0,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            UIPublicProfile obj = new UIPublicProfile(user);
            obj.display(); // goes to the UI insidechatroom page
        });
    }

    public void enter_private_profile_button(User user){
        //create a GUI page after clicking the edit private profile button
        JButton b = new JButton("Edit your private profile");//creating instance of JButton
        b.setBounds(0,100,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIPrivateProfile obj = new UIPrivateProfile();
                obj.display(); // goes to the UI insidechatroom page
            }
        });
    }

    public static void main(String[] args) {
    }

}
