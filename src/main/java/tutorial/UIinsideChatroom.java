package tutorial;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;
import tutorial.Chatroom;
import tutorial.User;
import tutorial.UIinsidechatroom_backend;
import tutorial.UIPublicProfile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.Objects;

import Storage.MessagesStorageGateway;
import Storage.MessagesStorageUsecase;

public class UIinsideChatroom {
    private Chatroom chatroom;
    private User user;
    private JFrame frame;
    private JTextArea chat_window;

    public UIinsideChatroom(Chatroom chatroom, User user){
        this.chatroom = chatroom;
        this.user = user;
    }
    public void display_current_chatroom(){
        //displays the current chatroom
        this.frame = new JFrame();
        this.frame.setSize(900, 900); //setting the size of the window
        this.frame.setTitle(this.chatroom.getName()); //setting the name for the title of the window

        this.chat_window = new JTextArea(""); //sets up the text window in chatroom window
        this.chat_window.setBounds(100, 50, 500, 500);
        this.setup_chatwindow_message(this.chat_window);
        this.frame.add(this.chat_window);


        display_member_lst(); //display its member lst
        send_message(this.chat_window, this.user.getUserDisplayName()); // setups the send message textbox and message button
        this.frame.setLayout(null);//using no layout managers
        this.frame.setVisible(true);//making the frame visible
        this.create_add_friend_menu(this.user);
        this.create_invite_friend_memu();
    }

    public void setup_chatwindow_message(JTextArea chat_window){
        for (String txt: this.chatroom.getMessage()) {
            chat_window.setText(txt);
        }
    }

    public void create_add_friend_menu(User user){
        JMenuBar b = new JMenuBar();
        JMenu user_lst = new JMenu();
        b.setBounds(650, 25, 100 ,50);
        user_lst.setText("add friend");
        for (String name:this.chatroom.getUserLst()){
            if (!Objects.equals(name, this.user.getUserDisplayName())) {
                JMenuItem item = new JMenuItem(name);
                user_lst.add(item);
                item.addActionListener(e ->  {
                        UIinsidechatroom_backend obj = new UIinsidechatroom_backend();
                        user.addUserToFriendList(obj.getUser(name));
                });
            }
        }
        b.add(user_lst);
        this.frame.add(b);
    }

    public void create_invite_friend_memu(){
        JMenuBar b = new JMenuBar();
        JMenu user_lst = new JMenu();
        b.setBounds(650, 75, 100 ,50);
        user_lst.setText("invite friend");
        for (User name:this.user.getFriendsList()){
            if (!name.getListofChatroom().contains(chatroom)){
                JMenuItem item = new JMenuItem(name.getUserDisplayName());
                user_lst.add(item);
                item.addActionListener(e -> {
                        this.chatroom.AddUser(name.getUserDisplayName());
                        name.addUserToChatroom(this.chatroom);
                        this.frame.dispose();
                        this.display_current_chatroom();
                });
            }
        }
        b.add(user_lst);
        this.frame.add(b);
    }

    public void display_member_lst(){
        //display this chatroom's member list
        //make every member displays as button, so click in opens that user's public profile page
        UIinsidechatroom_backend obj = new UIinsidechatroom_backend();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,0));
        for (String b: obj.getmember_lst(this.chatroom)){
            //creates the user icon, along with the functionality of clicking in to their public profile
            JButton button = this.create_public_profile_button(b);
            panel.add(button);
        }
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        container.add(panel);
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setBounds(800, 100, 100, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.frame.getContentPane().add(scrollPane);



    }

    public void send_message(JTextArea chatwindow, String name){
        //sends the string inputted and clears it after successfully sent
        JTextField text_box = new JTextField("Please enter your messages");
        text_box.setBounds(100, 700, 400, 100);
        this.frame.add(text_box); //adds the textbox to window
        JButton send_button = new JButton("Send"); //creates the button the send strings in textbox
        send_button.setBounds(700, 700, 100, 100);
        this.frame.add(send_button);
        send_button.addActionListener(e -> {

                //display the chat to window and remmber to put time and who sent it
                String current_string = chatwindow.getText();
                String time = LocalDateTime.now().toString(); //getting local time
                String string_now = time + "\n" + "From " +name + "\n" + text_box.getText();
                this.chatroom.addMessage(string_now);
                current_string += "\n" + string_now;
                chatwindow.setText(current_string); //displays it in chatwindow
        });
    }

    public JButton create_public_profile_button(String name){
        //create a GUI page after clicking the edit public profile button
        JButton b = new JButton(name);//creating instance of JButton
        b.setEnabled(true); //enables the button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIPublicProfile obj = new UIPublicProfile(user, user);
                obj.display(); // goes to the UI public profile page
            }
        });
        return b;
    }

    public static void main(String[] args) {
        //please run what is it in UIoutsideChatroom main,
        // you can click tut119 for a breif look in UIinsidechatroom
    }

}