package Login;

import tutorial.User;

public class LoginController {
    private String username;
    private String password;
    private LoginUseCase loginUseCase;

    public LoginController(String username, String password){
        this.username = username;
        this.password = password;
        this.loginUseCase = new LoginUseCase(username, password);
    }

    public boolean checkUser(String username, String password){
        return loginUseCase.checkUser(username, password);
    }

    public User getUser(){
        return loginUseCase.getUser();
    }


}
