package Storage;

import tutorial.User;

import java.util.Map;

public class UserStorageUseCase implements UserStorageGateway{
    Storage userStorage;
    Reader reader;

    public UserStorageUseCase(String username) {
        this.userStorage = new UserStorage(username);
        this.reader = new Reader();
    }

    @Override
    public User getData() {
        User info = (User) reader.Read(userStorage.readfile(), User.class);
        return info;
    }

    @Override
    public void saveData(User newUser) {
        userStorage.writefile(reader.ToString(newUser));
    }
}
