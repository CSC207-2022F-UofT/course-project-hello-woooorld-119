package Storage.Users;

import tutorial.User;

import java.util.Map;

public interface UserStorageGateway {
    User getData();
    void saveData(User new_user);
}
