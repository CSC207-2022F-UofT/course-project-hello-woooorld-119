package Storage;

import java.util.List;

class UserInfo {
    String profilePicPath;
    String bio;
    String status;
    String comment;
}

class AccountsInfo {
    String username;
    String password;
}

class MessagesInfo {
    String text;
    String date;
    String to;
}

class ChatroomsInfo {
    List messages;
    List users;
    List adminUsers;
}