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
    private final Integer button_width = 100;
    private final Integer button_length = 100;

    public UIoutsideChatroom(User user){
        this.user = user;
    }
    public void display(){
        //displays the window
        this.frame = new JFrame();
        this.frame.setSize(900, 900); //setting the size of the window
        this.frame.setTitle("Diskawd"); //setting the name for the title of the window
        display_friend_lst(); // calls to display public profile of this user's friends
        display_chatrooms(); // calls to display buttons to enter chatrooms that this user is in
        create_chatroom_button(); //calls to create a button to create chatroom
        enter_public_profile_button(this.user); //creates this user's public profile and allow edit
        enter_private_profile_button(this.user); //creates this user's private profile and allow edit
        this.frame.setLayout(null);//using no layout managers
        this.frame.setVisible(true);//making the frame visible
    }

    public void create_enter_chatroom_button(Chatroom chatroom, User user){
        //create a GUI button to enter this chatroom
        JButton b = new JButton(chatroom.getName());//creating instance of JButton
        b.setBounds(200,100,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true); //enables the button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIinsideChatroom obj = new UIinsideChatroom(chatroom, user);
                obj.display_current_chatroom(); // goes to the UI insidechatroom page
            }
        });
    }

    public void display_chatrooms(){
        //displays the chatroom with their icon picture
        UIoutsidechatroom_backend obj = new UIoutsidechatroom_backend();
        for (Chatroom chatroom: obj.getchatroomlst(this.user)){
            this.create_enter_chatroom_button(chatroom, this.user);
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
            Chatroom chatroom = new Chatroom(display_name, this.user.getUserDisplayName());//creates the chatroom
            ChatroomStorageGateway chatroom_storage = (ChatroomStorageGateway) new ChatroomStorageUsecase(display_name);
            chatroom_storage.saveData(chatroom);
            this.create_enter_chatroom_button(chatroom, this.user);
        });

    }

    public void enter_friend_public_profile_button(User user){
        //creates an icon when clicked, you can go into that user's public profile
        JButton b = new JButton(user.getUserDisplayName());//creating instance of JButton
        b.setBounds(800,100,button_width, button_length);//x axis, y axis, width, height
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true);
        b.addActionListener(e -> {
            UIPublicProfile obj = new UIPublicProfile(user);
            obj.display(); // goes to the UI profileprofile page for other user, not editable
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
            obj.display(); // goes to the UI publicprofile page
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
                obj.display(); // goes to the UI privateprofile page
            }
        });
    }

    public static void main(String[] args) {
        User evan = new User("evan", "ec105", "ec105");
        User Jeff = new User("Jeff", "Jeff", "Jeff");
        Chatroom tut119 = new Chatroom("tut119", "evan");
        evan.addUserToFriendList(Jeff);
        tut119.AddUser("evan");
        evan.addUserToChatroom(tut119);
        UIoutsideChatroom a = new UIoutsideChatroom(evan);
        a.display();

    }

}
