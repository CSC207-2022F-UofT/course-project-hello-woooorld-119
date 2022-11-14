package Storage;
import User.User;
import com.google.gson.Gson;

public class UserSetup {
    private String name;

    public UserSetup(String user_name) {
        this.name = user_name;
    }

    public User Recreate() {
        Storage user_storage = new UserStorage(name);
        Gson gson = new Gson();
        UserInfo information = gson.fromJson(user_storage.readfile(), UserInfo.class);

        User user = new User();
        user.setBio(information.bio);
        user.setProfilePic(information.profilePicPath);
        user.setStatus(information.status);
        user.setComment(information.comment);

        return user;
    }
}

