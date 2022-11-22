package tutorial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Messages.Message;
import Storage.ChatroomStorageGateway;


public class DirectMessage extends Chatroom{

    public DirectMessage(String name, String admin_name) {
        super(name, admin_name);
    }

    public int num_of_users(){
        return super.getUserList().size();
    }

    public void DM(String user2) throws Exception {
        if(this.num_of_users() == 1){
            super.AddUser(user2);
            super.setName(user2);
        }else {
            throw new Exception("Invalid direct message format");
        }
    }



    public void nickName(String nickname){
        super.setName(nickname);
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


