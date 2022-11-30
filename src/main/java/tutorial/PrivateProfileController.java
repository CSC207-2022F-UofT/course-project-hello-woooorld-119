package tutorial;

public class PrivateProfileController {
    private String password;
    private String displayName;
    private ProfileUseCase profileUseCase;

    public PrivateProfileController(User user){
        profileUseCase = new ProfileUseCase(user);
        password = profileUseCase.getPassword();
        displayName = profileUseCase.getDisplayName();
    }
    public String changePassword(String newPassword){
        String status = profileUseCase.setPassword(newPassword);
        return status;
    }
    public String changeDisplayName(String newName){
        String status = profileUseCase.setDisplayName(newName);
        return status;
    }
    public String getPassword(){
        return profileUseCase.getPassword();
    }
    public String getDisplayName(){
        return profileUseCase.getDisplayName();
    }

}
