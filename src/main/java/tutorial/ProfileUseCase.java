package tutorial;

import Storage.UserStorageUseCase;

public class ProfileUseCase {
    private String username;
    private String password;
    private String displayName;
    private User user;
    private UserStorageUseCase userStorage;

    public ProfileUseCase(User user){
        username = user.getUsername();
        password = user.getPassword();
        displayName = user.getUserDisplayName();
        this.user = user;
        userStorage = new UserStorageUseCase(username);
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getDisplayName(){
        return displayName;
    }
    public String setPassword(String newPassword){
        user.setPassword(newPassword);
        return "Success";
    }
    public String setDisplayName(String newDisplayName){
        user.setDisplayName(newDisplayName);
        return "Success";
    }
    public void modifyPassword(String newPassword){
        user.setPassword(newPassword);
        userStorage.saveData(user);
    }
    public void modifyDisplayName(String newName){
        user.setDisplayName(newName);
        userStorage.saveData(user);
    }


}
