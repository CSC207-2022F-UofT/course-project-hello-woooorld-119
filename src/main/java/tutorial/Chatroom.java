package tutorial;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Chatroom {
    private String name;
    private ArrayList<String> user_list; // list of unique usernames of the users in the chatroom
    private String admin_name; // User who created the chatroom
    public Chatroom(String name, String admin_name) {
        this.name = name;
        this.user_list = new ArrayList<>();
        this.admin_name = admin_name;

        this.user_list.add(admin_name);
    }

    public void AddUser(String username){
        this.user_list.add(username);

    }

    public void RemoveUser(String username){
        this.user_list.remove(username);
        if (user_list.size() == 0){
            // code to delete chatroom from storage
        }

    }


    public static String getName(){
        return this.name;
    }
    public void setName(String new_name){
        this.name = new_name;
    }
    public String getAdmin_name (){
        return this.admin_name;
    }

    public void setAdmin(String new_admin_name){
        this.admin_name = new_admin_name;
    }

    // to be done after storage is created
    public void setMessages(){
        // set up the Chatroom with all the messages from ChatroomStorage //
    }

    public void addMessage(String message) throws IOException {
        try (FileWriter f = new FileWriter("storage/messages/" + this.name + ".txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println(message);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
