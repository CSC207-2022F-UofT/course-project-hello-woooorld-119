package tutorial;
import Storage.ChatroomStorageGateway;
import Storage.ChatroomStorageUsecase;
import tutorial.Chatroom;
import tutorial.User;
import tutorial.UIinsidechatroom_backend;
import tutorial.UIPublicProfile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
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
        this.chat_window.setBounds(100, 0, 500, 500);
        this.frame.add(this.chat_window);

        display_member_lst(); //display its member lst
        send_message(this.chat_window, this.user.getUserDisplayName()); // setups the send message textbox and message button
        this.frame.setLayout(null);//using no layout managers
        this.frame.setVisible(true);//making the frame visible
    }

    public void display_member_lst(){
        //display this chatroom's member list
        //make every member displays as button, so click in opens that user's public profile page
        UIinsidechatroom_backend obj = new UIinsidechatroom_backend();

        for (String b: obj.getmember_lst(this.chatroom)){
            //creates the user icon, along with the functionality of clicking in to their public profile

            this.create_public_profile_button(b);
        }


    }

    public void send_message(JTextArea chatwindow, String name){
        //sends the string inputted and clears it after successfully sent
        JTextField text_box = new JTextField("Please enter your messages");
        text_box.setBounds(100, 700, 400, 100);
        this.frame.add(text_box); //adds the textbox to window
        JButton send_button = new JButton("Send"); //creates the button the send strings in textbox
        send_button.setBounds(700, 700, 100, 100);
        this.frame.add(send_button);
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //display the chat to window and remmber to put time and who sent it
                String current_string = chatwindow.getText();
                String time = LocalDateTime.now().toString(); //getting local time
                String string_now = time + "\n" + name + "\n" + text_box.getText();
                //MessagesStorageGateway obj = (MessagesStorageGateway) new MessagesStorageUsecase(); classes not fully implemented yet
                //obj.saveData(current_string);
                current_string += "\n" + string_now;
                chatwindow.setText(current_string); //displays it in chatwindow
            }
        });
    }

    public void create_public_profile_button(String name){
        //create a GUI page after clicking the edit public profile button
        JButton b = new JButton(name);//creating instance of JButton
        b.setBounds(800,100,100,100);
        this.frame.add(b);//adding button in JFrame
        b.setEnabled(true); //enables the button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIPublicProfile obj = new UIPublicProfile(user);
                obj.display(); // goes to the UI public profile page
            }
        });
    }

    public static void main(String[] args) {
        //please run what is it in UIoutsideChatroom main,
        // you can click tut119 for a breif look in UIinsidechatroom
    }

}